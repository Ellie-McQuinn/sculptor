package quest.toybox.sculptor

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import quest.toybox.sculptor.extension.SculptorExtension

abstract class SculptorPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create<SculptorExtension>("sculptor")
    }
}