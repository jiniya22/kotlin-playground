package xyz.applebox.kotlin.webclient

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import xyz.applebox.kotlin.book.Book

@RestController
class WebClientExample {

    val url = "http://localhost:8080/books"
    val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/books/block")
    fun getBooksUsingBlocking(): List<Book> {
        logger.info(">>>> Start RestTemplate")

        val restTemplate = RestTemplate()
        val response = restTemplate.exchange(url, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<Book>>() {})
        val result = response.body!!
        logger.info("result: {}", result)
        logger.info(">>>> End RestTemplate")
        return result
    }

    @GetMapping("/books/nonblock")
    fun getBooksUsingNonBlocking(): Flux<Book> {
        logger.info(">>> Start WebClient")
        var response = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToFlux(Book::class.java)
            .map {
                logger.info("result: {}", it)
                it
            }
        logger.info(">>> End WebClient")
        return response
    }
}