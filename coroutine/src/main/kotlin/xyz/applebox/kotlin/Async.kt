package xyz.applebox.kotlin

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a + b

fun main() = runBlocking<Unit> {
    val result1: Deferred<Int> = async {
        delay(100)
        sum(5, 2)
    }

    println("result1: ${result1.await()}")

    val result2 = async {
        delay(100)
        sum(11, 22)
    }

    println("result2: ${result2.await()}")
}