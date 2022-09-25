package xyz.applebox.kotlin.book

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService,
) {
    @GetMapping("")
    fun getAll(): Flux<Book> = bookService.getAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Mono<Book> = bookService.get(id)

    @PostMapping("")
    fun create(@RequestBody request: Map<String, Any>): Mono<Book> =
        bookService.create(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Mono<Void> =
        bookService.delete(id)
}