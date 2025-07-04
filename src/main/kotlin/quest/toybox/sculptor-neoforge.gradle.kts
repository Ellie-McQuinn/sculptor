package quest.toybox

import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("net.neoforged.moddev")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

neoForge {
    parchment {
        parchmentArtifact = sculptor.parchmentArtifact
    }
}