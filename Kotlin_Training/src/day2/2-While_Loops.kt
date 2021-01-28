package day2

fun main(){
    var a = 1
    //INFINITE LOOP!
//    while (a<5){
//        print(a)
//    }

    print("While: ")
    while (a<5){
        print(a)
        a++ //Make sure to write the increment when using while
    }

    print("\nDo-While: ")
    var i = 6
    do{
        print(i)
        i++
    }while(i<=5)
}