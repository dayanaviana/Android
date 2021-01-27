/*# Some In built in functions are available - HYPER FUNCTION
toByte(), toShort(), toInt(), toLong(), toFloat()*/

/*>Type conversion means when we want to convert one data type variable into another data type

> In kotlin implicit conversion of smaller type into larger data type is not supported however it is supported in java

Int-> double or Long

> In Koltin conversion is always done explicit in which smaller data type is converted into larger data type and vice versa
> This can be done using helper functions*/
package day1
fun main(){

    var a = 10;
    //var value2: Long = a  // compile time error
    var b :Long = a.toLong()
    println(b)

    var c : Short = a.toShort()
    println(c)

    var d : Long = 200
    var e : Int = d.toInt()
    println(e)

    var f : String = a.toString()
    println(f)

    var g : Float = a.toFloat()
    println(g)

}