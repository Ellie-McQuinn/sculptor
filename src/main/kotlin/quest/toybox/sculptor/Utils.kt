package quest.toybox.sculptor

import net.neoforged.moddevgradle.dsl.RunModel
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.api.project.IsolatedProject
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.project
import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import quest.toybox.sculptor.extension.SculptorExtension


fun <T: Any> ExtraPropertiesExtension.gets(key: String): T = get(key) as T
fun <T: Any> ExtraPropertiesExtension.find(key: String): T? = if (has(key)) { gets(key) } else { null }

fun parchmentArtifact(version: String) = "org.parchmentmc.data:parchment-${version}@zip"

fun getModVersion(version: String): String {
    return if (version.count { it == '.' } == 3) {
        version.substringAfter('.')
    } else {
        version
    }
}

fun displayName(name: String): String = if (name == "neoforge") {
    "NeoForge"
} else {
    name.uppercaseFirstChar()
}

fun NamedDomainObjectContainer<RunModel>.commonDataRun(common: Project, self: Project) {
    val sculptor = common.extensions.getByType<SculptorExtension>()

    configureEach {
        if (name == "data") {
            programArguments.addAll("--existing", common.file("src/main/resources").absolutePath)
        }
    }

    create("commonData") {
        ideName.convention("${displayName((common.name))} Data (${self.path})")

        if (sculptor.minecraftVersion.hasSplitDatagens()) {
            clientData()
        } else {
            data()
        }

        programArguments.addAll(
            "--mod", sculptor.modId,
            "--output", common.file("src/generated/resources").absolutePath,
            "--existing", common.file("src/main/resources").absolutePath,
            "--all"
        )

        systemProperty("sculptor.datagen.common", "true")
    }
}

fun Project.sculptorParent(configuration: String) {
    configurations {
        consumable("${configuration}Java")
        consumable("${configuration}Kotlin")
        consumable("${configuration}Resources")
    }

    afterEvaluate {
        extensions.getByName<SourceSetContainer>("sourceSets").named("main").configure {
            artifacts {
                java.sourceDirectories.forEach { add("${configuration}Java", it) }
                resources.sourceDirectories.forEach { add("${configuration}Resources", it) }

                extensions.configure<SourceDirectorySet>("kotlin") {
                    sourceDirectories.forEach { add("${configuration}Kotlin", it) }
                }
            }
        }
    }
}

@Suppress("UnstableApiUsage")
fun Project.sculptorChild(configuration: String, parent: IsolatedProject) {
    evaluationDependsOn(parent.path)

    configurations {
        create("${configuration}Java") { isCanBeResolved = true }
        create("${configuration}Kotlin") { isCanBeResolved = true }
        create("${configuration}Resources") { isCanBeResolved = true }
    }

    dependencies {
        "compileOnly"(project(path = parent.path))

        "commonJava"(project(path = parent.path, configuration = "${configuration}Java"))
        "commonKotlin"(project(path = parent.path, configuration = "${configuration}Kotlin"))
        "commonResources"(project(path = parent.path, configuration = "${configuration}Resources"))
    }

    tasks {
        named<JavaCompile>("compileJava") {
            dependsOn(configurations["${configuration}Java"])
            source(configurations["${configuration}Java"])
        }

        named<KotlinCompile>("compileKotlin") {
            dependsOn(configurations["${configuration}Kotlin"])
            source(configurations["${configuration}Kotlin"])
        }

        named<ProcessResources>("processResources") {
            dependsOn(configurations["${configuration}Resources"])
            from(configurations["${configuration}Resources"])
        }
    }
}