package io.github.chase22.derpibooru.tag

enum class TagCategory(
        val categoryName: String,
        val categoryDefinition: String
) {
    CHARACTER("character", "Character"),
    ERROR("error", "Incomplete Metadata"),
    OC("oc", "Original Character"),
    ORIGIN("origin", "Creator or Origin"),
    RATING("rating", "Rating"),
    SPECIES("species", "Species"),
    SPOILER("spoiler", "Spoiler"),
    CONTENT_FANMADE("content-fanmade", "Fan-Made Content"),
    CONTENT_OFFICIAL("content-official", "Official Content"),
    NONE("none", "No Category"),
    UNKNOWN("unknown", "Unknown Tag Category");

    companion object {
        fun getByName(name: String?): TagCategory {
            return name?.let { values().find { category ->  category.name == it } ?: UNKNOWN } ?: NONE
        }
    }
}
