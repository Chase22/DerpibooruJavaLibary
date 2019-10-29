package io.github.chase22.derpibooru.tag

import com.beust.klaxon.JsonBase
import com.beust.klaxon.JsonObject
import io.github.chase22.derpibooru.derpibooru.DerpibooruJsonMapper
import io.github.chase22.derpibooru.derpibooru.DerpibooruListMapper
import io.github.chase22.derpibooru.extensions.*

data class Tag(
        val id: Int,
        val name: String,
        val slug: String,
        val description: String,
        val shortDescription: String,
        val images: Int,
        val spoilerImageUri: String?,
        val namespace: String?,
        val nameInNamespace: String?,
        val category: TagCategory,
        val impliedTagIds: List<Int>,
        val aliases: List<String>?
)

class TagMapper: DerpibooruJsonMapper<Tag> {
    override fun deserialize(jsonBase: JsonBase): Tag {
        if (jsonBase is JsonObject) {

            val tag: JsonObject = if (jsonBase.contains("tag")) {
                jsonBase.objOrException("tag")
            } else {
                jsonBase
            }

            return Tag(
                    id = tag.intOrException("id"),
                    name = tag.stringOrException("name"),
                    description = tag.stringOrException("description"),
                    category = TagCategory.getByName(tag.string("category")),
                    images = tag.intOrException("images"),
                    impliedTagIds = tag.arrayOrException<Int>("implied_tag_ids").toList(),
                    nameInNamespace = tag.string("name_in_namespace"),
                    namespace = tag.string("namespace"),
                    shortDescription = tag.stringOrException("short_description"),
                    slug = tag.stringOrException("slug"),
                    spoilerImageUri = tag.string("spoiler_image_uri"),
                    aliases = jsonBase.array<String>("aliases")?.toList()
            )
        } else {
            throw JsonTypeException("Given object is an Array")
        }
    }
}

class TagListMapper: DerpibooruListMapper<Tag>(TagMapper())