package quest.toybox

import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import quest.toybox.sculptor.displayName
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

sculptor.mods {
    sculptor.optionalLibrary("neoforge_kotlin").ifPresent { library ->
        create("kotlin-for-forge") {
            required()

            artifacts {
                implementation(library)
            }
        }
    }

}

neoForge {
    version = sculptor.neoforgeVersion

    parchment {
        parchmentArtifact = sculptor.parchmentArtifact
    }

    runs {
        configureEach {
            ideName.convention("${displayName(project.name)} ${name.uppercaseFirstChar()} (${project.path})")
            disableIdeRun()
            systemProperty("neoforge.enabledGameTestNamespaces", sculptor.modId)
        }

        create("client") { client() }

        create("server") { server() }

        if (sculptor.hasDatagens) {
            create("data") {
                if (sculptor.minecraftVersion.hasSplitDatagens()) {
                    clientData()
                } else {
                    data()
                }

                programArguments.addAll(
                    "--mod", sculptor.modId,
                    "--output", file("src/generated/resources").absolutePath,
                    "--all"
                )
            }
        }
    }

    mods {
        create(sculptor.modId) {
            sourceSet(sourceSets.main.get())
        }
    }
}

if (sculptor.hasDatagens) {
    sourceSets.main {
        resources.srcDirs("src/generated/resources")
    }
}

tasks.processResources {
    exclude("*.accesswidener")
}
