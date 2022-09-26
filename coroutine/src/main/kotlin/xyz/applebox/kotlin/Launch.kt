package xyz.applebox.kotlin

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    val job1: Job = launch {
        val elapsedTime = measureTimeMillis {
            delay(500)
        }
        println("async task-1 $elapsedTime ms")
    }

    val job2: Job = launch(start = CoroutineStart.LAZY) {
        val elapsedTime = measureTimeMillis {
            delay(200)
        }
        println("async task-2 $elapsedTime ms")
    }

    println("start task-2")
    job2.start()
}