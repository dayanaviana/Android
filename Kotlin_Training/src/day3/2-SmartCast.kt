package day3

fun main(){

    var name:String = ""

    //error: trying to access length of a possible null variable
//    println(name.length)

    if(name != null){ //smart cast
        println(name.length)
    }

    //DEMO 3
    var obj:Any = "Hello World"

    if(obj is String){ //Automatically identify type
        println(obj.length)
    }
    if(obj !is String){
        //println(obj.l) //cant even find function length
    }else{
        println(obj.length)
    }

}