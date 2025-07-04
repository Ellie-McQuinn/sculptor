package quest.toybox

import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

neoForge {
    neoFormVersion = sculptor.minecraftVersion.neoFormVersion

    parchment {
        parchmentArtifact = sculptor.parchmentArtifact
    }
}

//sculptor.whenAdded(Key.DATA_GENERATION) {
//    sourceSets.main {
//        resources.srcDirs("src/generated/resources")
//    }
//}