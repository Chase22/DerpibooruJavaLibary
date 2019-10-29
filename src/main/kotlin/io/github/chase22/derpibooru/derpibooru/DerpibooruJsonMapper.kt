package io.github.chase22.derpibooru.derpibooru

import com.beust.klaxon.JsonBase

interface DerpibooruJsonMapper<out Object> {
    fun deserialize(jsonBase: JsonBase): Object
}
