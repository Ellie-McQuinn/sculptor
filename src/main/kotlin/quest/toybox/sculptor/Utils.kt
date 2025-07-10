package quest.toybox.sculptor

import net.neoforged.moddevgradle.dsl.RunModel
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.support.uppercaseFirstChar
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
        ideName.set("${displayName((common.name))} Data (${self.path})")

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