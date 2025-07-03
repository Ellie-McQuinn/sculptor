package quest.toybox.sculptor.extension

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import java.util.function.Consumer
import javax.inject.Inject

abstract class SculptorExtension @Inject constructor(val project: Project, val factory: ProviderFactory) {
    val features = mutableMapOf<FeatureKey<*>, Any>()
    val callbacks: MutableMap<FeatureKey<*>, Consumer<Any>> = mutableMapOf()

    fun <T: Any> flag(key: FeatureKey<T>, value: T) {
        if (key !in features) {
            features.put(key, value)
            callbacks.remove(key)?.accept(value)
        }
    }

    fun <T> get(key: FeatureKey<T>): Provider<T> {
        return factory.provider { features[key] as T }
    }

    fun getJavaVersion(): Provider<Int> {
        return get(FeatureKey.JAVA).orElse(get(FeatureKey.MINECRAFT).map { it.getJavaVersion() })
    }

    fun <T> whenAdded(type: FeatureKey<T>, callback: Consumer<T>) {
        val flag = get(type)

        if (flag.isPresent) {
            callback.accept(flag.get())
        } else {
            callbacks.put(type, callback as Consumer<Any>)
        }
    }
}