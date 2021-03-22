package com.android_training.testmokito

//Source: https://www.tutorialspoint.com/mockito/mockito_junit_integration.htm

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.invocation.InvocationOnMock
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MyMokitoTest {
    //Create Mock using annotation
    @InjectMocks
    var mathApplication = MathApplication()
    @Mock
    lateinit var calculatorService: CalculatorService

    //    @TestSubject
    var mathApplication1 = MathApplication()

    //Create mock without annotation
    lateinit var calcService: CalculatorService
    lateinit var mathApp: MathApplication
    @Before
    fun setup() {
        mathApp = MathApplication()
        calcService = mock(CalculatorService::class.java) //Mock Obj
        mathApp.setCalculatorService(calcService)
    }

    @Test
    fun testAdd() {
        //Specify the behaviour
        Mockito.`when`(calculatorService.add(3.0, 5.0)).thenReturn(8.0)

        //Test functionality
        Assert.assertEquals(calculatorService.add(3.0, 5.0), 8.0, 0.0)
    }
    @Test
    fun `Verify call add was made`() {
        //Specify the behaviour
        Mockito.`when`(calculatorService.add(3.0, 5.0)).thenReturn(8.0)

        Assert.assertEquals(mathApplication.add(3.0, 5.0), 8.0, 0.0)

        //Verify if method is being called
        Mockito.verify(calculatorService).add(3.0,5.0)
    }
    @Test
    fun `Add() called 3 times`() {
        //Specify the behaviour
        Mockito.`when`(calculatorService.add(3.0, 5.0)).thenReturn(8.0)

        Assert.assertEquals(mathApplication.add(3.0, 5.0), 8.0, 0.0)
        Assert.assertEquals(mathApplication.add(3.0, 5.0), 8.0, 0.0)
        Assert.assertEquals(mathApplication.add(3.0, 5.0), 8.0, 0.0)

        //Verify # of call on a method
        Mockito.verify(calculatorService, times(3)).add(3.0,5.0)
    }
    @Test
    fun `Multiply() never called`() {
        //Specify the behaviour
        Mockito.`when`(calculatorService.add(3.0, 5.0)).thenReturn(8.0)

        //Verify # of call on a method
        Mockito.verify(calculatorService, never()).multiply(3.0,5.0)
    }
//    @Test
//    fun `atLeastOnce`() {}
    @Test
    fun `atLeast`() {
        //add the behavior of calc service to add two numbers
        `when`(calculatorService.add(10.0, 20.0)).thenReturn(30.00)

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)

        //check a minimum 1 call count
//        verify(calculatorService, atLeastOnce()).subtract(20.0, 10.0)

        //check if add function is called minimum 2 times
        verify(calculatorService, atLeast(2)).add(10.0, 20.0)
//
    }
    @Test
    fun `atMost`() {
        //add the behavior of calc service to add two numbers
        `when`(calculatorService.add(10.0, 20.0)).thenReturn(30.00)

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)


//        //check if add function is called maximum 3 times
        verify(calculatorService, atMost(3)).add(10.0, 20.0)
    }
    @Test(expected = RuntimeException::class)
    fun `runtime exception`() {
        //add the behavior to throw exception
        doThrow(RuntimeException("Add operation not implemented"))
            .`when`(calculatorService).add(10.0, 20.0)

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0)
    }
    @Test
    fun `in call order`() {
        //add behavior
        `when`(calculatorService.add(20.0, 10.0)).thenReturn(30.0)
        `when`(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0)

        //test functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0)
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0.0)

        //create an inOrder verifier for a single mock
        val inOrder = inOrder(calculatorService)

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calculatorService).add(20.0, 10.0)
        inOrder.verify(calculatorService).subtract(20.0, 10.0)
    }
    @Test
    fun `Calbacks- generic interface`() {

        //add the behavior to add numbers
        `when`(calcService.add(20.0, 10.0)).thenAnswer{
                invocation: InvocationOnMock -> //get the arguments passed to mock
                val args = invocation.arguments

                //get the mock
                val mock = invocation.mock

                //return the result
                30.0
            }

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0)
    }
    @Test
    fun `Spying on real object`(){
        var mathApplication = MathApplication();
        var calculator = Calculator();
        var calcObj = spy(calculator);
        mathApplication.setCalculatorService(calcObj);
        //add above: spy @Before
        //add gradle: testImplementation 'org.mockito:mockito-inline:2.13.0'
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0)
    }
    @Test
    fun `Reset Mockito for reuse`() {
        //behavior
        `when`(calculatorService.add(20.0, 10.0)).thenReturn(30.0)
        //test functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0)

        //reset the mock
        reset(calculatorService)

        //test the add functionality after resetting the mock
        Assert.assertNotEquals(mathApplication.add(10.0, 10.0), 30.0, 0.0)
    }
    @Test
    fun `Given When Then`() {

        //Behaviour
        //Given
        given(calcService.add(20.0, 10.0)).willReturn(30.0)

        //when
        val result = calcService.add(20.0, 10.0)

        //Test functionality
        //then
        Assert.assertEquals(result, 30.0, 0.0)
    }
    @Test
    fun `timeout`(){//Test if method is called within stipulated time frame
        //add the behavior
        `when`(calculatorService.add(20.0, 10.0)).thenReturn(30.0)
        `when`(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0)

        //test functionality
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0.0)
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0)

        //verify call to add method to be completed within 100 ms
        Mockito.verify(calculatorService, timeout(100)).add(20.0, 10.0)

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given timeframe
        verify(calculatorService, timeout(100).times(1)).subtract(20.0, 10.0)
    }
}


