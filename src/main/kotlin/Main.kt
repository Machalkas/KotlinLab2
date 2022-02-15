import java.io.File

val fn="students"
fun main() {
    val stud=decodeStudent(readFile("./src/main/json_files/$fn.json"))
    stud.name="Вася"
    writeFile("./src/main/json_files/new_$fn.json",encodeStudent(stud))
}

fun readFile(file_name:String)=File(file_name).readText()
fun writeFile(file_name:String,content:String)=File(file_name).writeText(content)