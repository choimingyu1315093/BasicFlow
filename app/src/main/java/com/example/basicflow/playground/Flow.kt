package com.example.basicflow.playground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random


//Flow는 비동기 스트림이다.
//Cold Stream은 요청이 있을 때 보통 1:1로 값을 전달 / Hot Stream은 지속적으로 값을 전달
//반응형 프로그래밍(리액티브 프로그래밍)은 데이터가 변경될 때 특정 이벤트를 발생시켜서 데이터를 계속해서 전달하는 프로그래밍 방식
fun main() = runBlocking {
    flowSomething().collect {value ->
        println(value)
    }
}

fun flowSomething(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(500L)
    }
}