package xyz.applebox.kotlin.async

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun sum(a: Int, b: Int) = a + b

fun main() {
    val pool = Executors.newSingleThreadExecutor()
    val future = pool.submit(Callable {
        Thread.sleep(900L)
        sum(100, 200)
    })

    println("계산 시작")
    val futureResult = future.get(1000L, TimeUnit.MILLISECONDS) // 비동기 작업의 결과를 기다립니다
    println(futureResult)
    println("계산 종료")
}