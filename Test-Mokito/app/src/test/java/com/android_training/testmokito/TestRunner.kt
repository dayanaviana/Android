package com.android_training.testmokito

import org.junit.runner.JUnitCore


object TestRunner {
    @JvmStatic
    fun main(args: Array<String>) {
        val result =
            JUnitCore.runClasses(MyMokitoTest::class.java)
        for (failure in result.failures) {
            println(failure.toString())
        }
        println(result.wasSuccessful())
    }
}