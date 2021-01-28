package day2

fun main(){
    var student = Student1(1,"Bob")

    var emp = Employee1("Jeniffer","Olivera")
}

//Constructor without parameters
class Student(){}

//Primary Constructor
//constructor keyword is not needed if there's no annotations or visibility modifiers
class Student1(id:Int,name:String){}

//Primary constructor with initializer block: 3 Steps
class Client constructor(firstName:String,lastName:String){
    var firstName:String=""
    var lastName:String=""

    //init block: has access to parameters of the constructor
    //used to initialize the code
    init{
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

//Primary constructor with properties: 1 Step
class Employee1 constructor(var firstName:String, var lastName:String) {
    fun getFullName() {
        println("$firstName $lastName")
    }
}