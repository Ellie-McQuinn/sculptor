package quest.toybox

import org.gradle.kotlin.dsl.getByName
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("fabric-loom")
}

val sculptor = extensions.getByName<SculptorExtension>("sculptor")

dependencies {
    minecraft("com.mojang:minecraft:${sculptor.minecraftVersion}")

    mappings(
        provider {
            @Suppress("UnstableApiUsage")
            loom.layered {
                officialMojangMappings()
                parchment(sculptor.parchmentArtifact)
            }
        }
    )

    modImplementation("net.fabricmc:fabric-loader:${sculptor.minecraftVersion.minimumFabricLoaderVersion}")
}