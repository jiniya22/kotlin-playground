package xyz.applebox.kotlin.webflux

import reactor.core.publisher.Flux

data class Cellphone(
    val name: String,
    val price: Int,
    val currency: Currency,
)
enum class Currency {
    KRW, USD
}
fun main() {
    val iphone = Cellphone(name = "IPhone 13", price = 100, currency = Currency.KRW)
    val galaxy = Cellphone(name = "Galaxy 21", price = 90, currency = Currency.KRW)

    val flux: Flux<Cellphone> = Flux.just(iphone, galaxy)
    flux.subscribe(::println)
}