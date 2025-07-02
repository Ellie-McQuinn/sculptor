package quest.toybox

import org.gradle.kotlin.dsl.getByType
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByType<SculptorExtension>()

neoForge {
    parchment {
        parchmentArtifact = sculptor.parchmentArtifact.map { "org.parchmentmc.data:parchment-${it}@zip" }
    }
}