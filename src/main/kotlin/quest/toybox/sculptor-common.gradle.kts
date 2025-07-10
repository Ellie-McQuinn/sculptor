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

dependencies {
    compileOnly(sculptor.constants.findLibrary("fabric_mixin").orElseThrow())
    annotationProcessor(compileOnly(sculptor.constants.findLibrary("mixinextras_common").orElseThrow())!!)

    sculptor.constants.findLibrary("neoforge_kotlin").ifPresent {
        compileOnly(it)
    }
}

if (sculptor.hasDatagens) {
    sourceSets.main {
        resources.srcDirs("src/generated/resources")
    }
}
