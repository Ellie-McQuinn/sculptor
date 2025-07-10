package quest.toybox

import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension
import quest.toybox.sculptor.extension.SculptorExtension
import quest.toybox.sculptor.find
import quest.toybox.sculptor.getModVersion
import kotlin.jvm.optionals.getOrNull

plugins {
    `java-library`
    kotlin("jvm")
}

val sculptor = extensions.create<SculptorExtension>("sculptor")

base.archivesName = "${version}-${project.name}-${sculptor.minecraftVersion}"

java.toolchain {
    languageVersion = JavaLanguageVersion.of(sculptor.javaVersion)
    vendor = JvmVendorSpec.MICROSOFT
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release = sculptor.javaVersion
        options.encoding = "UTF-8"
    }
}

if (plugins.hasPlugin("org.jetbrains.kotlin.jvm")) {
    extensions.configure<KotlinJvmExtension> {
        compilerOptions {
            languageVersion = sculptor.kotlinVersion
        }
    }
}

// region // Shared Repositories...
repositories {
    mavenCentral()

    exclusiveContent {
        forRepository {
            maven {
                name = "Sponge"
                url = uri("https://repo.spongepowered.org/repository/maven-public/")
            }
        }
        filter { includeGroupAndSubgroups("org.spongepowered") }
    }

    exclusiveContent {
        forRepositories(
            maven {
                name = "ParchmentMC"
                url = uri("https://maven.parchmentmc.org/")
            },
            maven {
                name = "NeoForge"
                url = uri("https://maven.neoforged.net/releases/")
            }
        )
        filter { includeGroup("org.parchmentmc.data") }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Unofficial CurseForge Maven"
                url = uri("https://cursemaven.com/")
            }
        }
        filter {
            includeGroup("curse.maven")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth Maven"
                url = uri("https://api.modrinth.com/maven/")
            }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Kotlin for Forge Maven"
                url = uri("https://thedarkcolour.github.io/KotlinForForge/")
            }
        }
        filter {
            includeGroup("thedarkcolour")
        }
    }
}
// endregion

dependencies {
    implementation(sculptor.constants.findLibrary("jetbrains-annotations").get())
}

// region // Add Information to Jar...
val extraReplacements = ext.find<Map<String, String>>("extra_replacements")

tasks {
    jar.configure {
        exclude("**/datagen/**")
        exclude(".cache/**")

        rootDir.resolve("LICENSE").also { if (it.exists()) from(it) }

        archiveVersion = getModVersion(project.version.toString())
    }

    processResources.configure {
        val replacements = mutableMapOf(
            "version" to project.version,
            "group" to project.group,
            "mod_id" to sculptor.modId,
            "neoforge_version" to sculptor.neoforgeVersion,
            "java_version" to sculptor.javaVersion.toString(),
            "minecraft_version" to sculptor.minecraftVersion,
            "fabric_loader_version" to sculptor.fabricLoaderVersion
        )

        sculptor.constants.findLibrary("fabric_api").ifPresent {
            replacements.put("fabric_api_version", it.get().versionConstraint.requiredVersion)
        }

        sculptor.constants.findLibrary("fabric_kotlin").ifPresent {
            replacements.put("fabric_kotlin_version", it.get().versionConstraint.requiredVersion)
        }

        sculptor.constants.findLibrary("neoforge_kotlin").ifPresent {
            replacements.put("neoforge_kotlin_version", it.get().versionConstraint.requiredVersion)
        }

        extraReplacements?.also { replacements.putAll(it) }

        inputs.properties(replacements)

        filesMatching(listOf("fabric.mod.json", "META-INF/neoforge.mods.toml", "*.mixins.json", "*.mcmeta")) {
            expand(replacements)
        }
    }
}
// endregion
