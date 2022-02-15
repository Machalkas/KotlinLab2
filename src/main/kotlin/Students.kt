import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

@Serializable
data class Students(var students:Array<Student>)
@Serializable
data class Student(var name:String, var group:String, var grades:Grades)
@Serializable
data class Grades(var math:Int, var history:Int)

fun decodeStudents(json:String):Students{
    val stud=Json.decodeFromString<Students>(json)
    return stud
}
fun encodeStudents(student:Students):String{
    return Json.encodeToString(student)
}
