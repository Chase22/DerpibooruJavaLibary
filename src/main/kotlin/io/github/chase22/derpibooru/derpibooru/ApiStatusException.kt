package io.github.chase22.derpibooru.derpibooru

class ApiStatusException(statusCode: Int) : Throwable(
        "Derpibooru returned an unexpected status code $statusCode"
)
