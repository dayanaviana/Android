package day3

class Employee {
    var firstName: String = ""
    var lastName: String = ""
    var age: Int = 0

    fun getFullName(){
        println("$firstName $lastName")
    }
}

fun Employee.getAge(){
    println("$firstName is $age years old")
}
fun main(){
    //DEMO5

    var employee  = Employee()
    employee.firstName = "Mark"
    employee.lastName = "Smith"
    employee.age = 30

    employee.getFullName()
    employee.getAge()
}