package day1

fun main(){

    //Number
    var b : Byte = 10;
    println("Byte = $b | 8bit")

    var s1 : Short = 10
    println("Short = $s1 | 16bit")

    var i : Int = 10
    println("Int = $i | 32bit")

    var l : Long = 10
    println("Long = $l | 64bit")

    var f : Float = 10.1F
    println("Float = $f | 32bit")

    var d : Double = 10.2
    println("Float = $d | 64bit")

    var c1 : Char = 'c'
    println("Char = $c1 | 1bit")

    var b1 : Boolean = true
    println("Boolean = $b1 | 1bit")

    var s: String = "Marl"
    println("String = $s")

    //Array


    val number = 5.0F
    if(number is Float) {
        println("number is of type Float")
    }

    println("${number::class.simpleName}")    // "Float"
    println("${number::class.qualifiedName}") // "kotlin.Float"
}
