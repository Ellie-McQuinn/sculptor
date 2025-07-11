package quest.toybox.sculptor.extension

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import quest.toybox.sculptor.extension.dependency.DependencyType
import quest.toybox.sculptor.minecraft.MCVersions
import quest.toybox.sculptor.parchmentArtifact
import quest.toybox.sculptor.extension.dependency.ModDependency
import quest.toybox.sculptor.extension.dependency.RepositoryExclusions
import quest.toybox.sculptor.extension.dependency.UploadTarget
import java.net.URI
import java.util.Optional
import javax.inject.Inject
import kotlin.collections.iterator
import kotlin.jvm.optionals.getOrNull

abstract class SculptorExtension @Inject constructor(val project: Project, objects: ObjectFactory) {
    init {
        project.afterEvaluate {
            if (!areModsFinalized && mods.count() > 0) {
                throw IllegalStateException("Please call finalizeMods() in the SculptorExtension")
            }
        }
    }

    private val libs: VersionCatalog by lazy {
        project.extensions.getByName<VersionCatalogsExtension>("versionCatalogs").find("libs").get()
    }

    fun libs(): VersionCatalog = libs

    val minecraftVersion: MCVersions by lazy {
        libs.findVersion("minecraft").map { MCVersions.fromVersion(it.requiredVersion) }.get()
    }

    val javaVersion: Int by lazy {
        libs.findVersion("java").map { it.requiredVersion.toInt() }.getOrNull() ?: minecraftVersion.getJavaVersion()
    }

    val kotlinVersion: Optional<KotlinVersion> by lazy {
        libs.findVersion("kotlin").map { KotlinVersion.fromVersion(it.requiredVersion) }
    }

    val parchmentArtifact: String by lazy {
        parchmentArtifact(project.property("parchment_version").toString())
    }

    val neoforgeVersion: String by lazy {
        libs.findVersion("neoforge").get().requiredVersion
    }

    val fabricLoaderVersion: String by lazy {
        libs.findVersion("fabric_loader").map { it.requiredVersion }.getOrNull() ?: minecraftVersion.minimumFabricLoaderVersion
    }

    val hasDatagens: Boolean by lazy {
        project.findProperty("sculptor.datagens") == "true"
    }

    val modId: String by lazy {
        project.findProperty("mod_id") as? String ?: "unknown_project"
    }

    val modName: String by lazy {
        project.findProperty("mod_name") as? String ?: "Unknown Project"
    }

    private var areModsFinalized: Boolean = false
    private val mods: NamedDomainObjectContainer<ModDependency> = objects.domainObjectContainer(ModDependency::class.java)

    fun mods(configuration: NamedDomainObjectContainer<ModDependency>.() -> Unit) {
        if (!areModsFinalized) {
            configuration.invoke(mods)
        } else {
            throw IllegalStateException("Tried configuring mods when mods have already been frozen.")
        }
    }

    fun finalizeMods() {
        areModsFinalized = true

        val repositories: MutableMap<URI, RepositoryExclusions> = mutableMapOf()
        for (mod in mods) {
            for (repository in mod.getRepositories()) {
                if (repository.key in repositories) {
                    repositories[repository.key]!!.groups.addAll(repository.value.groups)
                } else {
                    repositories[repository.key] = repository.value
                }
            }
        }

        with(project) {
            repositories {
                for (repository in repositories) {
                    if (repository.value.groups.isEmpty()) {
                        maven {
                            name = repository.value.name
                            url = repository.key
                        }
                    } else {
                        exclusiveContent {
                            forRepositories(maven {
                                name = repository.value.name
                                url = repository.key
                            })
                            filter {
                                for (group in repository.value.groups) {
                                    if (group.endsWith(".*")) {
                                        includeGroupAndSubgroups(group.substringBeforeLast(".*"))
                                    } else {
                                        includeGroup(group)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            dependencies {
                for (mod in mods) {
                    for (artifact in mod.getArtifacts()) {
                        artifact.invoke(this, mod.type.get() == DependencyType.REQUIRED || mod.enabledAtRuntime.get())
                    }
                }
            }

            val enabledMods = mods.filter { it.type.get() != DependencyType.DISABLED }

            extensions.getByType<SourceSetContainer>().named("main") {
                java.srcDirs(enabledMods.map { it.javaDirectory }.filter { file(it).exists() })

                if (project.plugins.hasPlugin("org.jetbrains.kotlin.jvm")) {
                    this.extensions.getByName<SourceDirectorySet>("kotlin").srcDirs(
                        enabledMods.map { it.javaDirectory }.filter { file(it).exists() }
                    )
                }
            }
        }
    }

    fun getDependencyIds(target: UploadTarget, type: DependencyType): Set<String> {
        return mods.filter { it.type.get() == type }.mapNotNull {
            when (target) {
                UploadTarget.CURSEFORGE -> it.curseforgeName.orNull
                UploadTarget.MODRINTH -> it.modrinthName.orNull
                UploadTarget.GITHUB -> null
            }
        }.toSet()
    }
}