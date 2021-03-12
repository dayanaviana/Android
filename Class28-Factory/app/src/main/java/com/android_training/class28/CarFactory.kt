package com.android_training.class28

fun main(){
    var car = CarFactory.getCarInstance(Cars.Audi.ordinal)
    var model = car?.getCarModel()
    println(model)
}

//https://www.geeksforgeeks.org/enum-classes-in-kotlin/
 enum class Cars{
     Honda, BMW, Audi
 }

class CarFactory {
    companion object {
        fun getCarInstance(id: Int): ICar?{
            when(id) {
                0 -> return Honda()
                1 -> return BMW()
                2 -> return Audi()
                else -> return null
            }
        }
    }
}

interface ICar{
    fun getCarColor(): String
    fun getCarModel(): String
    fun drive()
    fun stop()
}

class Honda : ICar{
    override fun getCarColor(): String {
        return "Black"
    }

    override fun getCarModel(): String {
        return "Honda City 2020"
    }

    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}
class BMW : ICar{
    override fun getCarColor(): String {
        return "White"
    }

    override fun getCarModel(): String {
        return "M PD 5495 2021"
    }

    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}
class Audi : ICar{
    override fun getCarColor(): String {
        return "Gray"
    }

    override fun getCarModel(): String {
        return "Audi Q3 2021"
    }

    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}

class Engine(var type: String){}
class Tire(var numberOfTires: Int){}
