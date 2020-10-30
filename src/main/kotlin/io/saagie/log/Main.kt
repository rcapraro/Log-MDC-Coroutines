package io.saagie.log

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.slf4j.MDCContext
import mu.withLoggingContext

suspend fun main() {
    val service = Service()
    withLoggingContext("user" to "richard", "company" to "saagie") {
        (1..5).forEach { i ->
            withLoggingContext("i" to i.toString()) {
                GlobalScope.launch(MDCContext()) {
                    service.multipleOfThree(i)
                    service.multipleOfSeven(i)
                    withLoggingContext("action" to "multipleOfFive($i)") {
                        service.multipleOfFive(i)
                    }
                }
            }
        }
    }
    delay(10000)
}

