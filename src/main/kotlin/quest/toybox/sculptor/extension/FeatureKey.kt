package quest.toybox.sculptor.extension

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import quest.toybox.sculptor.minecraft.MCVersions

interface FeatureKey<T>{
    companion object {
        val MINECRAFT = new<MCVersions>()
        val PARCHMENT = new<String>()

        val JAVA = new<Int>()
        val KOTLIN = new<KotlinVersion>()

        val DATA_GENERATION = new<Unit>()

        fun <T> new(): FeatureKey<T> = object : FeatureKey<T> {}
    }
}