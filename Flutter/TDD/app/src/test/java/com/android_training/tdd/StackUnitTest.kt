package com.android_training.tdd

import com.google.common.truth.Expect
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StackUnitTest {
    lateinit var objStack: UserStack

    @Before
    fun alocateMemory(){
        objStack = UserStack()
    }

    @Test
    fun testPush(){
        objStack.push(1)
        assertEquals(1, objStack.array.size)
        objStack.push(2)
        assertEquals(2,objStack.array.size)
    }

    @Test
    fun testPop(){
        objStack.push(1)
        objStack.push(2)
        var element = objStack.pop()
        assertEquals(1, objStack.array.size)
        var element1 = objStack.pop()
        assertEquals(1,element1)
    }

    @Test
    fun checkNull(){
        var result: Boolean = objStack.checkNull()
        assertEquals(true, result)
    }

    @Test
    fun checkNotNull(){
        objStack.push(1)
        var result: Boolean = objStack.checkNotNull()
        assertEquals(true, result)
    }

    @Test
    fun testPeep(){
        objStack.push(1)
        objStack.push(2)
        objStack.push(3)
        var removed:Int = objStack.peep(1)
        assertEquals(2, removed)
        var removed2:Int = objStack.peep(1)
        assertEquals(3, removed2)
    }
}