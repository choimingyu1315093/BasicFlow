package com.example.basicflow.playground

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //flowOf
    flowOf(1,2,3,4,5).collect{value ->
        println(value)
    }

    //이거와 같은 의미다
    flow {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
        emit(5)
    }.collect {value ->
        println(value)
    }

    //asFlow
    listOf(1,2,3,4,5).asFlow().collect {value ->
        println(value)
    }
}