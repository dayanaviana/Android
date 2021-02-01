package day3

class Student6 {
    private var _id: Int = 0
    private var _name: String = ""
    private var _passMark: Int = 40

    fun display() {
        println("Id:$_id, Name:$_name, Pass Mark:$_passMark")
    }

    // getters and setters
    fun setID(id: Int) {
        if (id <= 0)
            throw Exception("Id cannot be zero or negative")
        this._id = id;
    }

    fun setName(name: String) {
        if(name.isEmpty())
            throw Exception("Name cannot be blank")
        this._name = name;
    }

    fun getId() :Int{
        return this._id
    }
    fun getName() :String{
        return this._name
    }
    fun getPassMark() :Int{
        return this._passMark
    }

}

fun main(){
    //DEMO8
    var stu6 = Student6()
    stu6.setID(7)
    stu6.setName("John")

    println(stu6.getId())
    println(stu6.getName())
    println(stu6.getPassMark())

    stu6.display()
}

