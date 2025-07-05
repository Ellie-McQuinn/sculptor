package quest.toybox

import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import quest.toybox.sculptor.displayName
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("fabric-loom")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

loom {
    runs {
        configureEach {
            configName = "${displayName(project.name)} ${name.uppercaseFirstChar()}"
            isIdeConfigGenerated = true
        }
        named("client") { client() }

        named("server") { server() }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${sculptor.minecraftVersion}")

    mappings(
        provider {
            @Suppress("UnstableApiUsage")
            loom.layered {
                officialMojangMappings()
                parchment(sculptor.parchmentArtifact)
            }
        }
    )

    modImplementation("net.fabricmc:fabric-loader:${sculptor.fabricLoaderVersion}")
}

sculptor.mods {
    sculptor.fabricApiVersion.ifPresent { version ->
        create("fabric-api") {
            required()

            artifacts {
                modImplementation(group = "net.fabricmc.fabric-api", name = "fabric-api", version = version)
            }
        }
    }

    sculptor.fabricKotlinVersion.ifPresent { version ->
        create("fabric-language-kotlin") {
            required()

            artifacts {
                modImplementation(group = "net.fabricmc", name = "fabric-language-kotlin", version = version)
            }
        }
    }
}
