package day1

fun main(){
    //Arithmetic: +, -, *, /, /
    var a = 10
    var b = 10
    println(a+b)
    println(a-b)
    println(a*b)
    println(a/b)

    //Relational: >, <, >=, <=, ==, !=
    if(a>b){
        println("a is greater")
    }else{
        println("b is greater")
    }

    //Assignment: =, +=, -=
    var c = 10
    var d = 20
    c += d
    println(c) //30

    //Logical: &&, !!, !
    var x =10
    var y = 20
    var z = 30
    if(x>20 && y < 20){
        println("x>20 && y < 20")
    }else{
        println("x<20 && y<20")
    }
}