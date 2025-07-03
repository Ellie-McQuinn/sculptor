package quest.toybox.sculptor.extension

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import quest.toybox.sculptor.minecraft.MCVersions

interface Key<T>{
    companion object {
        val MINECRAFT = new<MCVersions>()
        val PARCHMENT = new<String>()

        val JAVA = new<Int>()
        val KOTLIN = new<KotlinVersion>()

        val DATA_GENERATION = new<Unit>()

        fun <T> new(): Key<T> = object : Key<T> {}
    }
}