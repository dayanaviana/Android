# Kotlin

> Kotlin is now the official programming language for android development
> Previously we use java but after google made announcement to make kotlin as official language for android development it become hugely popular

> Kotlin is statically-type, general purpose programming language which is wisely used to develop android and web application
> It runs on JVM and can be used where ever we can use java
> It. Can babe. Use to develop android app, server side app and much more

> Kotlin was developed by JetBrains, this is the same company who developed android studio and other popular IDEs for different language


# Features of Kotlin
1. Concise - kotlin reduces writing the extra code and make ur code more concise
2. Null safety - kotlin is null safe language which aim to eliminate the NullPointerException which is very much common in java
3. Interoperable - Kotlin easily consume a java code and java can consume kotlin code
4. Smart cast - it explicit typecast the immutable values and insert the value in it safe cast. Automatically 
5. Compilation time - it has better performance and fast compilation time
6. Extension function - kotlin support extension functions and properties which means we can extend the functionality of the class without making change in the original code.


Simple Kotlin Program


fun main(){
    println("Hello World")
}

// Hello World


# Varibale
> variables refers to a memory location where we can store some data or value which can be access or manipulate while executing a program

> In kotlin we no need specify the data type based on the initial value data type will be associated
> In kotlin we can var or val keyword to declare a variable

Syntax in Kotlin
-----------------
Var <variable_name> = 10
Val <variable_name> = 20


// Java
<data_type> <variable_name>;   // declaration
<variable_name> = 10;          // initialisation
<data_type> <variable_name> = 10;  // declaration with initalization


Var : if we want to create a mutable variable that means the variable value can be changed
Val : if we want to create a immutable variable which value cannot be change. Like a constant


// Variables
    
    var a = 10
    a = 20  // value can be change
    
    val b = 20
    //b = 20  value cannot be change
    
    var name = ""
    
    //int c = 10;
    var i : Int = 10
    var s : String = "Marl"
    var d : Double = 10.12

# var and val
Var - mutable
Val - immutable


# Data Types
Data type refer to the type and size of data associated with variable
Data type is used for declaration of memory location of variable which determines the size

In kotlin everything is an object which means we can call member function and properties on any. Variable


Kotlin built in data types are categorised as
> Number
> Character
> Boolean
> Array
> String


Number type data are those which can hold number type data
Byte 		8 bit
Short		16 bit
Int		32 bit
Long		64 bit
Float		32 bit
Double		64 bit

Character type can hold single character declare using ''
Char		4 bit

Boolean type can store either true or false
Boolean 	1 bit


Array


String type in kotlin represented by String class, string is immutable
Var a = ""
String 



    println("X = "+ x + ", Y = "+ y)
    
    println("X = $x, Y = $y")
    println("${ x + y }")



# Type Conversion

>Type conversion means when we want to convert one data type variable into another data type

> In kotlin implicit conversion of smaller type into larger data type is not supported however it is supported in java

Int-> double or Long

> In Koltin conversion is always done explicit in which smaller data type is converted into larger data type and vice versa
> This can be done using helper functions


# Some In built in functions are available
toByte()
toShort()
toInt()
toLong()
toFloat()


Example:
 // type conversion

    var value1 = 10;
    //var value2: Long = a  // compile time error

    var value3 = 10
    var value4: Long = value3.toLong()

    var value5: Long = 200
    var value6: Int = value5.toInt()

    println(value6)



# Operators
Operators are special characters which perform operation on different variables of different types

> Arithmetic   + - * / %
> Relational  > < >= <= == !=
> Assignment. = += -=
> Logical  && || !


# Condition Statement
If esle
when

# Loops









