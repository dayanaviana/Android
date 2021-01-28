package day2

fun main(){
    //DEMO15
    println("DEMO 15")
    var fte = FullTimeEmployee()
    var pte = PartTimeEmployee()
    fte.firstName="Mark"
    fte.lastName="Smith"
    pte.firstName="Paul"
    pte.lastName="Watson"
    fte.getFullName()
    pte.getFullName()


    //DEMO 16
    println("\nDEMO 16")
    var chi = Child1(123)
    chi.display()

    //DEMO17
    println("\nDEMO 17")
    var chi2 = Child2(10,"Mark")
}

//DEMO14
//open enable class to be inherited
open class Parent{}
class Child : Parent(){}

//DEMO15
open class Employee5{
    var id:Int = 0
    var firstName:String = ""
    var lastName:String=""
    var gender:String=""
    fun getFullName(){println("Full Name: $firstName $lastName")}
}
class FullTimeEmployee : Employee5() {
    var annualSalary:Int = 0 }
class PartTimeEmployee : Employee5(){
    var hourSalary:Int = 0 }

//DEMO 16
open class Parent1(var x:Int){ var a = 10}
class Child1(var id: Int):Parent1(id){
    fun display(){println("a:$a, id:$id, x:$x")}
}


//DEMO17
// super means parent class
open class Parent2(){
    //constructor(){}
    //this() calls primary constructor
    constructor(id: Int, name:String) : this() {
        println("Parent: Name:$name, id:$id")
    }
}
//Cannot call primary constructor on child and primary constructor on parent from secondary constructors
//class Child2(x:Int) : Parent2{
class Child2 : Parent2 {
    constructor(id:Int, name:String): super(id,name){
        println("Child: Name:$name, id:$id")
    }
}