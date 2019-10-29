package io.github.chase22.derpibooru.derpibooru

interface DerpibooruMethod<Mapper: DerpibooruJsonMapper<Body>, Body> {
    val path: String

    val objectMapper: Mapper
}