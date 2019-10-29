package io.github.chase22.derpibooru.derpibooru

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonBase
import io.github.chase22.derpibooru.extensions.JsonTypeException

abstract class DerpibooruListMapper<Body: Any>(
        private val jsonMapper: DerpibooruJsonMapper<Body>
): DerpibooruJsonMapper<List<Body>> {

    override fun deserialize(jsonBase: JsonBase): List<Body> {
        if (jsonBase is JsonArray<*>) {
            return jsonBase.toList().mapNotNull { jsonMapper.deserialize(it as JsonBase) }
        } else {
            throw JsonTypeException("Given base was not an array")
        }
    }
}