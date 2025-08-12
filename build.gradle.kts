import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    idea
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "quest.toybox.sculptor"
version = "0.0.28"

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
    // https://projects.neoforged.net/neoforged/moddevgradle/
    implementation(group = "net.neoforged", name = "moddev-gradle", version = "2.0.99")
    // https://maven.fabricmc.net/net/fabricmc/fabric-loom/
    implementation(group = "net.fabricmc", name = "fabric-loom", version = "1.11.1")

    implementation(
        group = "org.jetbrains.gradle.plugin.idea-ext",
        name = "org.jetbrains.gradle.plugin.idea-ext.gradle.plugin",
        version = "1.2"
    )

    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation(group = "com.google.code.gson", name = "gson", version = "2.13.1")

    implementation(group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version = "2.1.0")
}

// Find checksums here: https://gradle.org/release-checksums/
// Run gradlew :wrapper a couple of times to update.
tasks.wrapper {
    gradleVersion = "9.0.0"
    distributionSha256Sum = "8fad3d78296ca518113f3d29016617c7f9367dc005f932bd9d93bf45ba46072b"
    distributionType = Wrapper.DistributionType.BIN
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
