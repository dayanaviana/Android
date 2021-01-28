package day2

fun main(){

    //BREAK
    //Terminate the loop
    print("\nBreak: ")
    for(i in 1..10){
        if( i == 5){
            break
        }
        print(i)
    }

    //CONTINUE: Used to repeat the loop
    print("\nPrint: ")
    for(i in 1..10){
        if( i == 5){
            continue
        }
        print(i)
    }
}