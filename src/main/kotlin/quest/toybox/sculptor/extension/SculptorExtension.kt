package quest.toybox.sculptor.extension

import org.gradle.api.provider.Property
import quest.toybox.sculptor.minecraft.MCVersions
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

abstract class SculptorExtension {
    abstract val minecraftVersion: Property<MCVersions>
    abstract val parchmentArtifact: Property<String>

    abstract val javaVersion: Property<Int>
    abstract val kotlinVersion: Property<KotlinVersion>

    init {
        minecraftVersion.finalizeValueOnRead()
        parchmentArtifact.finalizeValueOnRead()

        javaVersion.convention(minecraftVersion.map { it.getJavaVersion() }).finalizeValueOnRead()
        kotlinVersion.convention(KotlinVersion.KOTLIN_2_1)
    }
}