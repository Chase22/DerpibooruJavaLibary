package io.github.chase22.derpibooru.tag

import io.github.chase22.derpibooru.derpibooru.DerpibooruMethod

class TagMethod: DerpibooruMethod<TagListMapper, List<Tag>> {
    override val path: String = "tags"
    override val objectMapper: TagListMapper = TagListMapper()
}