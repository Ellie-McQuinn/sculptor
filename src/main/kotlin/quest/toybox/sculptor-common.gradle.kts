package quest.toybox

import org.gradle.kotlin.dsl.getByType
import quest.toybox.sculptor.extension.FeatureKey
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByType<SculptorExtension>()

afterEvaluate {
    neoForge {
        neoFormVersion = sculptor.get(FeatureKey.MINECRAFT).map { it.neoFormVersion }.get()

        parchment {
            parchmentArtifact = sculptor.get(FeatureKey.PARCHMENT).map { "org.parchmentmc.data:parchment-${it}@zip" }
        }
    }
}

sculptor.whenAdded(FeatureKey.DATA_GENERATION) {
    sourceSets.main {
        resources.srcDirs("src/generated/resources")
    }
}