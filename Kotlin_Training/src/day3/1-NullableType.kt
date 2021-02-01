package day3

fun main() {

    var str: String? = ""
    str = null

//
//    var str2: String = null //compile time error
//    var str3 :String = ""
//    str3 = null //compile time error
//

    var name: String? = "Mark"
    //if (name?.length > 0) {}else{}

    var length = if (name != null) name.length else -1
    println("Name lenght: $length")


    //Trying to Cast Int to String
    var obj2: Any = 123

    //Works \o/
    var obj4: String = "Hello world"
    var str4: String? = obj4 as String?

    //safe cast: as?
    println("\nSafe cast")
    var obj5: Any = "Hello world"
    var str5: String? = obj5 as? String
    var str6: Int? = obj5 as? Int
    println("String to String: $str5")
    println("String to Int: $str6")

    //unsafe cast: as
    //through exception
//    var obj7: Any? = null
//    var str7: String? = obj7 as String
//    println("unsafe cast: $str7")
}