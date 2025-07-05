package quest.toybox.sculptor

import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.kotlin.dsl.support.uppercaseFirstChar


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