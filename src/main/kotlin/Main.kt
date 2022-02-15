import java.io.File

val file_name="students"
val path="./src/main/json_files/"
fun main() {
    val stud=decodeStudent(readFile("$path$file_name.json"))
    stud.name="Вася"
    writeFile("${path}new_$file_name.json",encodeStudent(stud))
}

fun readFile(file_name:String)=File(file_name).readText()
fun writeFile(file_name:String,content:String)=File(file_name).writeText(content)