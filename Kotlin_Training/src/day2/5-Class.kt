package day2

fun main(){
    var obj = Test() //no need of NEW keyword
    obj.hello()

    var calc = Calculator()
    calc.addNumber(4,3)

    var emp = Employee()
    emp.saveInfo(1,"Joye","Cally", 34, 'M')
    emp.readInfo()
}

class Test{
    fun hello(){
        println("Test Class says: Hello!")
    }
}

class Calculator {
    var num1: Int = 0
    var num2: Int =0

    fun addNumber(num1:Int, num2:Int){
        println(num1+num2)
    }
}

class Employee{
    var id: Int = 0
    var firstName: String = ""
    var lastName: String = ""
    var age: Byte = 0
    var gender: Char = 'F'

    fun saveInfo(id: Int, firstName:String, lastName:String, age:Byte, gender:Char){
        this.id = id
        this.firstName=firstName
        this.lastName=lastName
        this.age=age
        this.gender=gender
    }

    fun readInfo(){
        println("\nEmployee $id Info:")
        println("Name: $firstName $lastName")
        println("Age:$age, Gender:$gender")
    }
}