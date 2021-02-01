package day3

//We don't have to create getters and setters on Kotlin
//POJO class created automaticaly
data class Employee6(
    var id:Int? = null,
    var firstName: String? = null,
    var email: String? = null,
    var age: Int? = null

){}

class User{
    //create getters and setters
    private var name:String? = null
    private var email:String? = null

    //old syntax, not need to write get/set anymore
    private var id: Int? = null
    get() = field
    set(value){field = value}

}