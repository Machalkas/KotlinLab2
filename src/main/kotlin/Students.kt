import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

@Serializable
data class Student(var name:String, var group:String, var grades:Grades)
@Serializable
data class Grades(var math:Int, var history:Int)

fun decodeStudent(json:String):Student{
    val stud=Json.decodeFromString<Student>(json)
    return stud
}
fun encodeStudent(student:Student):String{
    return Json.encodeToString(student)
}
