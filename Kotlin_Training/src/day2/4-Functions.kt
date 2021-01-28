package day2

fun main(){
    printHello()
    addNumber(10,20)
    println("Multiply: "+multiply(2,7))

    addNumber_withdefaults()

    getInfo(100,"Mark","mark@mail.com")
    getInfo(300, email = "paul@mail.com", name="Paul")
}

//Function without return type and parameter
fun printHello(){
    println("Hello world!")
}

//Function with parameter
fun addNumber(num1 :Int, num2 :Int){
    println("Sum: ${num1 + num2}")
}

//Function with return
fun multiply(num1 :Int, num2 :Int) :Int {
    return num1*num2
}

//Function with default value
fun addNumber_withdefaults(num1 :Int = 3, num2 :Int = 25){
    println("Sum with defaults: ${num1 + num2}")
}

fun getInfo(rollNNumber :Int, name :String, email :String){
    println("Student: Number:$rollNNumber, Name:$name, Email:$email ")
}
