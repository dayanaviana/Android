package day2

class Customer (var name: String){
    constructor(id:Int, name: String):this(name){
        println("Customer Id: $id")
        println("Customer Name: $name")
    }
}

fun main(){
    var cu1 = Customer("Mark")
    var cu2 = Customer(10,"Paul")
}