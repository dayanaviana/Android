package day3

class Student{
    var id: Int? = null
    var firstName : String? = null

    fun setData(id:Int, firstName:String){
        this.id = id
        this.firstName = firstName
    }

    fun getData(){
        println("Id: $id, Name:$firstName")
    }

    companion object{
        var schoolName: String = "New School"

        fun getSchoolName(){
            println("School Name: $schoolName")
        }
    }
}

//Extension Function for companion object
fun Student.Companion.print1(){
    println("Student Companion printing 1")
}

fun main(){
    var stu = Student()
    stu.setData(1,"Mark")
    stu.getData()
    Student.print1()
}