package io.github.chase22.derpibooru.derpibooru

import com.beust.klaxon.JsonBase
import com.beust.klaxon.Parser
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.Dsl
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.Response
import org.asynchttpclient.util.HttpConstants
import java.util.concurrent.CompletableFuture

class DerpibooruClient {
    private val baseUrl: String = "https://derpibooru.org"
    private val asyncHttpClient: AsyncHttpClient = Dsl.asyncHttpClient()

    fun <Body, Mapper: DerpibooruJsonMapper<Body>> execute(method: DerpibooruMethod<Mapper, Body>): CompletableFuture<Body> {
        val request = RequestBuilder(HttpConstants.Methods.GET)
                .setUrl("$baseUrl/${method.path}.json")
                .build()

        return asyncHttpClient.executeRequest(request)
                .toCompletableFuture()
                .thenApply(this::handleHttpStatus)
                .thenApply { Parser.default().parse(it!!.responseBodyAsStream) as JsonBase }
                .thenApply { method.objectMapper.deserialize(it) }
    }

    private fun handleHttpStatus(it: Response): Response? {
        if (it.statusCode != 200) {
            throw ApiStatusException(it.statusCode)
        }
        return it
    }
}