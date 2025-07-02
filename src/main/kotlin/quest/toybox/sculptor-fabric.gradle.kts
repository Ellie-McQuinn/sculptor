package quest.toybox

import org.gradle.kotlin.dsl.getByType
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("fabric-loom")
}

val sculptor = extensions.getByType<SculptorExtension>()

dependencies {
    minecraft(sculptor.minecraftVersion.map { "com.mojang:minecraft:${it}" })

    mappings(
        provider {
            @Suppress("UnstableApiUsage")
            loom.layered {
                officialMojangMappings()
                parchment(sculptor.parchmentArtifact.map { "org.parchmentmc.data:parchment-${it}@zip" })
            }
        }
    )
}