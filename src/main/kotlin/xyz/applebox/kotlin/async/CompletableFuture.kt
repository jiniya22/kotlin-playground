package xyz.applebox.kotlin.async

import java.util.concurrent.CompletableFuture

fun main() {
    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000L)
        sum(100, 200)
    }

    println("계산 시작")
    completableFuture.thenApplyAsync(::println)

    while (!completableFuture.isDone) {
        Thread.sleep(500L)
        println("계산 결과를 집계 중입니다.")
    }
    println("계산 종료")
}