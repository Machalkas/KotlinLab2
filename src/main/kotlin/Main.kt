import java.io.File

val file_name="students"
val path="./src/main/json_files/"
fun main() {
    val stud=decode(readFile("$path$file_name.json"))
    stud.students[0].name="Василий"
    for (i in stud.students){
        i.grades.history=4
    }
    writeFile("${path}new_$file_name.json",encode(stud))
}

fun readFile(file_name:String)=File(file_name).readText()
fun writeFile(file_name:String,content:String)=File(file_name).writeText(content)