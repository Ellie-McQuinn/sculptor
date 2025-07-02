package quest.toybox

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    java
    kotlin("jvm")
}

val sculptor = extensions.create<SculptorExtension>("sculptor")

java.toolchain {
    languageVersion = provider { JavaLanguageVersion.of(sculptor.javaVersion.get()) }
    vendor = JvmVendorSpec.MICROSOFT
}

kotlin {
    compilerOptions {
        jvmTarget = provider { JvmTarget.fromTarget(java.toolchain.languageVersion.get().toString()) }
        languageVersion = sculptor.kotlinVersion
    }
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release = sculptor.javaVersion.get()
        options.encoding = "UTF-8"
    }
}