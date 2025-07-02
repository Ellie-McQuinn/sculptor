package quest.toybox.sculptor.extension

import org.gradle.api.provider.Property
import quest.toybox.sculptor.minecraft.MCVersions

abstract class SculptorExtension {
    abstract val minecraftVersion: Property<MCVersions>
    abstract val parchmentArtifact: Property<String>

    init {
        minecraftVersion.finalizeValueOnRead()
        parchmentArtifact.finalizeValueOnRead()
    }
}