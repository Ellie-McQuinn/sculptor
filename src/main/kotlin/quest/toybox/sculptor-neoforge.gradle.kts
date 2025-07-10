package quest.toybox

import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import quest.toybox.sculptor.displayName
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

neoForge {
    version = sculptor.neoforgeVersion

    parchment {
        parchmentArtifact = sculptor.parchmentArtifact
    }

    runs {
        configureEach {
            ideName.convention("${displayName(project.name)} ${name.uppercaseFirstChar()} (${project.path})")
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
}
