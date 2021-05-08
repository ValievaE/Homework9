import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext


//fun main() = runBlocking {
//    val job = CoroutineScope(EmptyCoroutineContext).launch {
//        launch {
//            delay(500)
//            println("ok") // <--
//        }
//        launch {
//            delay(500)
//            println("ok")
//        }
//    }
//    delay(100)
//
//    job.cancelAndJoin()
//
//}

//fun main() = runBlocking {
//    val job = CoroutineScope(EmptyCoroutineContext).launch {
//        val child = launch {
//            delay(500)
//            println("ok") // <--
//        }
//        launch {
//            delay(500)
//            println("ok")
//        }
//        delay(100)
//        child.cancel()
//    }
//    delay(100)
//    job.join()
//}

//fun main() {
//    CoroutineScope(EmptyCoroutineContext).launch {
//        try {
//            coroutineScope {
//                throw Exception("something bad happened")
//            }
//        } catch (e: Exception) {
//            e.printStackTrace() // <--
//
//        }
//    }
//    Thread.sleep(1000)
//}

//fun main() {
//    CoroutineScope(EmptyCoroutineContext).launch {
//        try {
//            supervisorScope {
//                throw Exception("something bad happened")
//            }
//        } catch (e: Exception) {
//
//            e.printStackTrace() // <--
//
//        }
//    }
//    Thread.sleep(1000)
//}

//fun main() {
//    CoroutineScope(EmptyCoroutineContext).launch {
//        try {
//            coroutineScope {
//                launch {
//                    delay(500)
//                    throw Exception("something bad happened") // <--
//                }
//                launch {
//
//                    throw Exception("something bad happened")
//                }
//            }
//        } catch (e: Exception) {
//           // println("e.printStackTrace")
//            e.printStackTrace()
//        }
//    }
//    Thread.sleep(1000)
//}
//fun main() {
//    CoroutineScope(EmptyCoroutineContext).launch {
//        CoroutineScope(EmptyCoroutineContext).launch {
//            launch {
//                delay(1000)
//                println("ok1") // <--
//            }
//            launch {
//                delay(500)
//                println("ok2")
//            }
//            throw Exception("something bad happened")
//        }
//    }
//    Thread.sleep(1000)
//}

fun main() {
    CoroutineScope(EmptyCoroutineContext).launch {
        CoroutineScope(EmptyCoroutineContext + SupervisorJob()).launch {
            launch {
                delay(1000)
                println("ok") // <--
            }
            launch {
                delay(500)
                println("ok")
            }
            throw Exception("something bad happened")
        }
    }
    Thread.sleep(1000)
}