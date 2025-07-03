package quest.toybox

import org.gradle.kotlin.dsl.getByType
import quest.toybox.sculptor.extension.FeatureKey
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    id("quest.toybox.sculptor-shared")
    id("fabric-loom")
}

val sculptor = extensions.getByType<SculptorExtension>()

dependencies {
    minecraft(sculptor.get(FeatureKey.MINECRAFT).map { "com.mojang:minecraft:${it}" })

    mappings(
        provider {
            @Suppress("UnstableApiUsage")
            loom.layered {
                officialMojangMappings()
                parchment(sculptor.get(FeatureKey.PARCHMENT).map { "org.parchmentmc.data:parchment-${it}@zip" })
            }
        }
    )

    modImplementation(sculptor.get(FeatureKey.MINECRAFT).map { "net.fabricmc:fabric-loader:${it.minimumFabricLoaderVersion}" })
}