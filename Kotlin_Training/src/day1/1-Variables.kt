/*variables refers to a memory location where we can store some data or value
which can be accessed or manipulated while executing a program

var : mutable variable (variable value can be changed)
val : immutable variable (value cannot be change. Like a constant)*/

package day1
fun main(){
    println("Hello World")

    //VARIABLES
    var a = 10
    a = 20 // value can be changed

    val b = 20
    // b = 30 // value cannot be change

    var name = ""
    //var name = null //cannot be null

    //int c = 10; Java syntax
    var c: Int = 10;
    var s: String = "Marl"
    var d: Double = 10.1

    //traditional print
    println("X = "+ c + ", Y = "+ c)

    //more concise print
    println("X = $c, Y = $c")

    //print expression
    println("${ c + c }")
}