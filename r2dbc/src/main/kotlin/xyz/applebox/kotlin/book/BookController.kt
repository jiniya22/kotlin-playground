package xyz.applebox.kotlin.book

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/books")
class BookController(
    private val bookRepository: BookRepository
) {

    @GetMapping("{name}")
    fun getByName(@PathVariable name: String): Mono<Book> =
        bookRepository.findByName(name)

    @PostMapping
    fun create(@RequestBody map: Map<String, Any>): Mono<Book> {
        val book = Book(
            name = map["name"].toString(),
            price = map["price"] as Int,
        )
        return bookRepository.save(book)
    }
}