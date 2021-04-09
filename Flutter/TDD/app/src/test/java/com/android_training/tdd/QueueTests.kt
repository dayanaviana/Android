package com.android_training.tdd

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class QueueTests {
    lateinit var queue: UserQueue

    @Before
    fun setup(){
        queue = UserQueue()
    }

    @Test
    fun insertTest(){
        assertEquals(0, queue.size)
        queue.add(4)
        assertEquals(1, queue.size)
    }

    @ExperimentalStdlibApi
    @Test
    fun removeTest(){
        queue.add(4)
        queue.add(5)
        assertEquals(2, queue.size)
        assertEquals(4,queue.remove())
        assertEquals(1, queue.size)
        assertEquals(5,queue.remove())
        assertEquals(null,queue.remove())
    }

    @ExperimentalStdlibApi
    @Test
    fun peek(){
        assertEquals(null, queue.peek())
        queue.add(4)
        assertEquals(4, queue.peek())
        queue.add(5)
        assertEquals(4, queue.peek())
        queue.remove()
        assertEquals(5, queue.peek())
    }

    @Test
    fun peep(){
        assertEquals(null, queue.peep(0))
        queue.add(12)
        assertEquals(12, queue.peep(0))
        queue.add(15)
        assertEquals(12, queue.peep(0))
        assertEquals(15, queue.peep(1))
        assertEquals(null, queue.peep(-1))
        assertEquals(null, queue.peep(20))
    }

    @ExperimentalStdlibApi
    @Test
    fun checkIsEmpty(){
        assertEquals(true, queue.isEmpty)
        queue.add(122)
        assertEquals(false,queue.isEmpty)
        queue.remove()
        assertEquals(true, queue.isEmpty)
    }
}