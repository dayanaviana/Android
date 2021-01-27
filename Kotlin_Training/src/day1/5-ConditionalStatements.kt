package day1

fun main(){

    //TRADITIONAL IF ELSE
    var x = 15

    if(x > 10){
        println("Greater then 10")
    }else{
        println("Less than 10")
    }

    //KOTLIN: IF ELSE LIKE AN EXPRESSION
    var num1 = 10
    var num2 = 20
    var result = if(num1>num2)
        "$num1 is greater then $num2"
    else
        "$num1 is less then $num2"
    println(result)

    //MULTIPLE CONDITIONS
    var num3 = 10
    var result1 = if(num3>0)
        "$num1 is greater then 0"
    else if (num3 < 0)
        "$num1 is less then 0"
    else
        println("$num3 is equal to zero")
    println(result1)

    //PRACTICING
    var str = "Hello"
    var hello = if (str == "Hello")
        str
    else ""
    println(str)

    //SWITCH = WHEN WITHOUT EXPRESSION
    var number = 1
    when(number){
        1-> println("One")
        2-> println("two")
        else -> "Invalid number"
    }

    //WHEN WITH EXPRESSION
    var number2 = 2
    var result2 = when(number2){
        1-> println("One")
        2-> println("two")
        else -> "Invalid number"
    }
    println(result2)

    //WHEN WITH MULTIPLE STATEMENTS
    var number3 = 3
    var result3 = when(number3){
        1-> {
            print("My number is: ")
            println("One")
        }
        2-> {
            print("My number is: ")
            println("two")
        }
        else -> "Invalid number"
    }
    println(result3)
    //kotlin.Unit == not null == void

    //WHEN WITH MULTIPLE STATEMENTS
    var num4 = 1
    when(num4){
        1,3,5,7,9 -> {
            println("Odd number!")}
        2, 4, 6, 8 -> {
            println("Even number!")
        }
    }

    //WHEN WITH A RANGE
    var num5 = 1
    when(num5){
        in 1..5 -> println("number is between 1-5")
        in 6..10 -> println("number is between 6-10")
    }

    //PRACTICING
    var num6 = 6
    var result6 = when(num6) {
        1 -> "one"
        2 -> "two"
        else -> if (num6 > 2)
            "big"
        else
            "small"
    }
    println(result6)

    //PRACTICING
    var num7 = 8;
    var result7 = when(num7%2){
        0 -> "Even number"
        else -> "Odd number"
    }
    println(result7)
}
