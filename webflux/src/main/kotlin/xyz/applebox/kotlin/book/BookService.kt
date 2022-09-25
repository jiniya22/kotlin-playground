package xyz.applebox.kotlin.book

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
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
        return books.toFlux()
    }

    fun get(id: Long): Mono<Book> {
        return books.find { id == it.id }.toMono()
    }

    fun create(request: Map<String, Any>): Mono<Book> {
        return request.toMono()
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
        return books.find { it.id == id }.toMono()
            .map { books.remove(it) }
            .then()
    }
}