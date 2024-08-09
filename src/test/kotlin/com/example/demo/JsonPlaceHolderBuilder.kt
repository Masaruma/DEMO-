package com.example.demo

class JsonPlaceHolderBuilder {
    var id: Int = 0
    var slug: String = ""
    var url: String = ""
    var title: String = ""
    var content: String = ""
    var image: String = ""
    var thumbnail: String = ""
    var status: String = ""
    var category: String = ""
    var publishedAt: String = ""
    var updatedAt: String = ""
    var userId: Int = 0

    fun setId(value: Int): JsonPlaceHolderBuilder {
        this.id = value
        return this
    }
    fun setSlug(value: String): JsonPlaceHolderBuilder {
        this.slug = value
        return this
    }
    fun setUrl(value: String): JsonPlaceHolderBuilder {
        this.url = value
        return this
    }
    fun setTitle(value: String): JsonPlaceHolderBuilder {
        this.title = value
        return this
    }
    fun setContent(value: String): JsonPlaceHolderBuilder {
        this.content = value
        return this
    }
    fun setImage(value: String): JsonPlaceHolderBuilder {
        this.image = value
        return this
    }
    fun setThumbnail(value: String): JsonPlaceHolderBuilder {
        this.thumbnail = value
        return this
    }
    fun setStatus(value: String): JsonPlaceHolderBuilder {
        this.status = value
        return this
    }
    fun setCategory(value: String): JsonPlaceHolderBuilder {
        this.category = value
        return this
    }
    fun setPublishedAt(value: String): JsonPlaceHolderBuilder {
        this.publishedAt = value
        return this
    }
    fun setUpdatedAt(value: String): JsonPlaceHolderBuilder {
        this.updatedAt = value
        return this
    }
    fun setUserId(value: Int): JsonPlaceHolderBuilder {
        this.userId = value
        return this
    }

    fun build(): JsonPlaceHolder {
        return JsonPlaceHolder(
            id = this.id,
            slug = this.slug,
            url = this.url,
            title = this.title,
            content = this.content,
            image = this.image,
            thumbnail = this.thumbnail,
            status = this.status,
            category = this.category,
            publishedAt = this.publishedAt,
            updatedAt = this.updatedAt,
            userId = this.userId,
        )
    }
}
