package com.example.basicflow.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

fun main() = runBlocking {
    val result = withTimeoutOrNull(500L){
        flowSomething2().collect {value ->
            println(value)
        }
        true
    } ?: false

    if(!result){
        println("Cancel")
    }
}

fun flowSomething2(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(100L)
    }
}