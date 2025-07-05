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
            ideName = "${displayName(project.name)} ${name.uppercaseFirstChar()} (${project.path})"
        }

        create("client") { client() }

        create("server") { server() }
    }
}