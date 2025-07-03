package quest.toybox

import org.gradle.kotlin.dsl.getByType
import quest.toybox.sculptor.extension.Key
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByType<SculptorExtension>()

afterEvaluate {
    neoForge {
        neoFormVersion = sculptor.get(Key.MINECRAFT).map { it.neoFormVersion }.get()

        parchment {
            parchmentArtifact = sculptor.get(Key.PARCHMENT).map { "org.parchmentmc.data:parchment-${it}@zip" }
        }
    }
}

sculptor.whenAdded(Key.DATA_GENERATION) {
    sourceSets.main {
        resources.srcDirs("src/generated/resources")
    }
}