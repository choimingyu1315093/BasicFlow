Flow는 비동기 스트림이다.
반응형(리액티브) 프로그래밍은 데이터가 변경될 때 특정 이벤트를 발생시켜서 데이터를 계속해서 전달하는 프로그래밍 방식.
ViewModel은 LiveData를 이용해서 데이터의 변화를 감지하고 UI에 전송하는 역할

FlowType에는 flowOf, asFlow
ex) flowOf(1,2,3,4,5).collect
ex) listOf(1,2,3,4,5).asFlow.collect

Flow Operator
map. filter, transform, take, takeWhile, drop, dropWhile, count, reduce
