package io.saagie.log

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import kotlin.random.Random

class Service {

    private val logger = KotlinLogging.logger {}

    suspend fun multipleOfThree(i: Int): Int = withContext(Dispatchers.IO + MDCContext()) {
        delay(Random.nextLong(100, 1000))
        val result = i * 3
        logger.info { "multipleOfThree $result" }
        result
    }

    suspend fun multipleOfFive(i: Int): Int = withContext(Dispatchers.IO + MDCContext()) {
        delay(Random.nextLong(100, 1000))
        val result = i * 5
        logger.info { "multipleOfFive $result" }
        result
    }

    suspend fun multipleOfSeven(i: Int) = withContext(Dispatchers.IO + MDCContext()) {
        delay(Random.nextLong(100, 1000))
        val result = i * 7
        logger.info { "multipleOfSeven $result" }
        i * 7
    }
}