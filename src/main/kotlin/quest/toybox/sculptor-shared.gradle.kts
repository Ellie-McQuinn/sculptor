package quest.toybox

import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension
import quest.toybox.sculptor.extension.Key
import quest.toybox.sculptor.extension.SculptorExtension
import kotlin.apply

plugins {
    java
}

val sculptor = extensions.create<SculptorExtension>("sculptor")

java.toolchain {
    languageVersion = sculptor.getJavaVersion().map { JavaLanguageVersion.of(it) }
    vendor = JvmVendorSpec.MICROSOFT
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release = sculptor.getJavaVersion()
        options.encoding = "UTF-8"
    }
}

sculptor.whenAdded(Key.KOTLIN) { version ->
    extensions.getByType<KotlinJvmExtension>().apply {
        compilerOptions {
            languageVersion.set(version)
        }
    }
}