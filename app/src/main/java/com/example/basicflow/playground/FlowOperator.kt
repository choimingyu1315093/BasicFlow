package com.example.basicflow.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun main() = runBlocking {
    //map
    flowSomething3().map {
        "$it $it"
    }.collect {value ->
        println("map $value")
    }

    //filter
    flowSomething3().filter {
        it % 2 == 0
    }.collect { value ->
        println("filter $value")
    }

    //transform
    (1..20).asFlow().transform {
        emit(it)
        emit(someCalc(it))
    }.collect {
        println("transform $it")
    }

    //take 갯수
    (1..20).asFlow().transform {
        emit(someCalc(it))
    }.take(5).collect {
        println("take $it")
    }

    //takeWhile 조건
    (1..20).asFlow().transform {
        emit(someCalc(it))
    }.takeWhile {
        it < 15
    }.collect {
        println("takeWhile $it")
    }

    //drop 갯수 만큼 버린다.
    (1..20).asFlow().transform {
        emit(someCalc(it))
    }.drop(5).collect {
        println("drop $it")
    }

    //drop 조건
    (1..20).asFlow().transform {
        emit(someCalc(it))
    }.dropWhile {
        it < 15
    }.collect {
        println("dropWhile $it")
    }

    //count 반환 갯수
    val count = (1..20).asFlow().count {
        it % 2 == 0
    }
    print(count)

    //reduce
    val result =(1..20).asFlow().reduce { a, b -> //a = 1, b = 2
        a+b //3이 다음 a값이 된다.
    }
    println(result)
}

fun flowSomething3(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(500L)
    }
}

suspend fun someCalc(i: Int): Int {
    delay(100L)
    return i + 1
}