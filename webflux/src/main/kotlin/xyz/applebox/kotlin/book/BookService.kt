package xyz.applebox.kotlin.book

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

data class Book(
    val id: Long,
    val name: String,
    val price: Int
)

@Service
class BookService {
    private final val nextId = AtomicLong(0)

    val books = mutableListOf(
        Book(id = nextId.incrementAndGet(), name = "Spring 시작하기", price = 25000),
        Book(id = nextId.incrementAndGet(), name = "Vanilla JS 정복하기", price = 29000),
    )

    fun getAll(): Flux<Book> {
        return Flux.fromIterable(books)
    }

    fun get(id: Long): Mono<Book> {
        return Mono.justOrEmpty(books.find { id == it.id })
    }

    fun create(request: Map<String, Any>): Mono<Book> {
        return Mono.just(request)
            .map { m ->
                val book = Book(
                    id = nextId.incrementAndGet(),
                    name = m["name"].toString(),
                    price = m["price"] as Int
                )
                books.add(book)
                book
            }
    }

    fun delete(id: Long): Mono<Void> {
        return Mono.justOrEmpty(books.find { it.id == id })
            .map { books.remove(it) }
            .then()
    }
}