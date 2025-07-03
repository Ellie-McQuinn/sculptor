package quest.toybox.sculptor.extension

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import java.util.function.Consumer
import javax.inject.Inject

abstract class SculptorExtension @Inject constructor(val project: Project, val factory: ProviderFactory) {
    val features = mutableMapOf<Key<*>, Any>()
    val callbacks: MutableMap<Key<*>, Consumer<Any>> = mutableMapOf()

    fun <T: Any> put(key: Key<T>, value: T) {
        if (key !in features) {
            features.put(key, value)
            callbacks.remove(key)?.accept(value)
        }
    }

    fun <T> get(key: Key<T>): Provider<T> {
        return factory.provider { features[key] as T }
    }

    fun getJavaVersion(): Provider<Int> {
        return get(Key.JAVA).orElse(get(Key.MINECRAFT).map { it.getJavaVersion() })
    }

    fun <T> whenAdded(type: Key<T>, callback: Consumer<T>) {
        val flag = get(type)

        if (flag.isPresent) {
            callback.accept(flag.get())
        } else {
            callbacks.put(type, callback as Consumer<Any>)
        }
    }
}