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
    val sculptorLibs = sculptor.libs()

    compileOnly(sculptorLibs.findLibrary("fabric_mixin").orElseThrow())

    sculptorLibs.findLibrary("mixinextras_common").orElseThrow().also {
        compileOnly(it)
        annotationProcessor(it)
    }

    sculptorLibs.findLibrary("neoforge_kotlin").ifPresent {
        compileOnly(it)
    }
}

if (sculptor.hasDatagens) {
    sourceSets.main {
        resources.srcDirs("src/generated/resources")
    }
}
