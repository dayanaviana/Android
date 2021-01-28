package day2

fun main(){

    //JAVA
    //for(int i=0; i<10; i++){ }

    //KOTLIN
    //for ( item in collection) { }
    print("\nPrint Array: ")
    var names = arrayOf("Mark","Paul","Jason")
    for(name in names){
        print("$name, ")
    }

    print("\nPrint Array: ")
    var numbers = arrayOf(10,20,30,40,50)
    for(number in numbers){
        print("$number ")
    }

    //RANGE
    print("\nPrint a RANGE: ")
    for(i in 1..5){
        print(i)
    }

    //DO NOT PRINT ANYTHING
    for(i in 5..1){
        println(i)
    }

    //REVERSE LOOP ( 1 by 1)
    print("\nReverse Loop: ")
    for(j in 5 downTo 1){
        print(j)
    }

    //JUMP BY STEPS
    print("\nLoop with Steps: ")
    for(i in 1..10 step 3){
        print(i)
    }

    //REVERSE FOR WITH STEPS
    print("\nReverse FOR with STEPS: ")
    for(j in 5 downTo 1){
        print(j)
    }
}