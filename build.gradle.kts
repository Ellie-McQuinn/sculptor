import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    idea
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "quest.toybox.sculptor"
version = "0.0.2"

gradlePlugin {
    plugins {
        create("sculptor-main") {
            id = "quest.toybox.sculptor-main"
            implementationClass = "quest.toybox.sculptor.SculptorPlugin"
        }
    }
}

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
    mavenCentral()
}

// Find checksums here: https://gradle.org/release-checksums/
// Run gradlew :wrapper a couple of times to update.
tasks.wrapper {
    gradleVersion = "8.14.2"
    distributionSha256Sum = "7197a12f450794931532469d4ff21a59ea2c1cd59a3ec3f89c035c3c420a6999"
    distributionType = Wrapper.DistributionType.BIN
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}
