package day3

fun main(){
    var firstName: String? = null
    var lastName: String? = "Smith"

    //make sure it is not null
    var length1 : Int = if(firstName != null) firstName.length else -1
    var length2 : Int = if(lastName != null) lastName.length else -1
    println(length1)
    println(length2)

    //ELVIS EXPRESSION ?:
    var len1 : Int = firstName?.length ?: -1
    var len2 : Int = lastName?.length ?: -1
    println(len1)
    println(len2)
}