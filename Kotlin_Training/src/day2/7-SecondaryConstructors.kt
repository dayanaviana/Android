package day2

class Test2 {
    constructor(id: Int){
        println("Secondary Constructor, $id")
    }
    constructor(name: String){
        println("Secondary Constructor, $name")
    }
}

class User{
    constructor(firstName:String){
        println("User, First Name:$firstName")
    }
    //calls first constructor
    constructor(firstName: String, lastName:String):this(firstName){
        println("User, Last Name:$lastName")
    }
}

fun main(){
    var obj = Test2(10)
    var obj2 = Test2("Hello")

    var obj3 = User("Mike","Onofrio")

}