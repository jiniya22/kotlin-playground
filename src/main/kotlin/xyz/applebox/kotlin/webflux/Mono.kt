package xyz.applebox.kotlin.webflux

import reactor.core.publisher.Mono

fun main() {
    val mono: Mono<String> = Mono.just("Hello world!")
    println(mono)
    mono.subscribe(::println)
}