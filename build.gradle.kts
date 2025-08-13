import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    idea
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "quest.toybox.sculptor"
version = "0.0.29"

java.toolchain {
    languageVersion = JavaLanguageVersion.of(21)
    vendor = JvmVendorSpec.MICROSOFT
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 21
}

kotlin {
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_1
        apiVersion = KotlinVersion.KOTLIN_2_1
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()

    exclusiveContent {
        forRepository {
            maven {
                name = "FabricMC's Maven"
                url = uri("https://maven.fabricmc.net/")
            }
        }
        filter {
            includeGroupAndSubgroups("net.fabricmc")
        }
    }
}

dependencies {
    implementation(
        group = "net.neoforged",
        name = "moddev-gradle",
        version = "2.0.107" // https://projects.neoforged.net/neoforged/moddevgradle/
    )

    implementation(
        group = "net.fabricmc",
        name = "fabric-loom",
        version = "1.11.7" // https://maven.fabricmc.net/net/fabricmc/fabric-loom/
    )

    implementation(
        group = "org.jetbrains.gradle.plugin.idea-ext",
        name = "org.jetbrains.gradle.plugin.idea-ext.gradle.plugin",
        version = "1.2"
    )

    implementation(
        group = "com.google.code.gson",
        name = "gson",
        version = "2.13.1" // https://mvnrepository.com/artifact/com.google.code.gson/gson
    )

    implementation(
        group = "org.jetbrains.kotlin",
        name = "kotlin-gradle-plugin",
        version = "2.1.0"
    )
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
