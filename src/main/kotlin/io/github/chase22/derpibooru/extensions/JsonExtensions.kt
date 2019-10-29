package io.github.chase22.derpibooru.extensions

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject

fun JsonObject.intOrException(fieldName: String): Int {
    return int(fieldName) ?: throw JsonMappingException(fieldName)
}

fun JsonObject.stringOrException(fieldName: String): String {
    return string(fieldName) ?: throw JsonMappingException(fieldName)
}

fun <T> JsonObject.arrayOrException(fieldName: String): JsonArray<T> {
    return array(fieldName) ?: throw JsonMappingException(fieldName)
}

fun JsonObject.objOrException(fieldName: String): JsonObject {
    return obj(fieldName) ?: throw JsonMappingException(fieldName)
}

abstract class JsonException(message: String?): Throwable(message)

class JsonMappingException(fieldName: String) : JsonException("Could not map json. Field $fieldName didn't exist")
class JsonTypeException(message: String): JsonException(message)