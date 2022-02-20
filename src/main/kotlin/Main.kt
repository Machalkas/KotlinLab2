import java.io.File

val file_name="students"
val path="./src/main/files/"
fun main() {
//    val g= arrayOf(Grade("math",5))
//    val st=Student("kek","11",g)
//    val stud=Students(arrayOf(st))
//    print(stud)
    val stud=decodeJson(readFile("$path$file_name.json"))
    print(stud)
    stud.students[0].name="Василий"
    for (i in stud.students){
        for (j in i.grades) {
            if(j.subject=="history") j.mark=4
        }
    }
    writeFile("${path}new_$file_name.json",encodeJson(stud))

    stud.students[1].name="this is Cbor"
    writeBinaryFile("${path}new_$file_name.cbor",encodeCbor(stud))
    val stud_cbor=decodeCbor(readBinaryFile("${path}new_$file_name.cbor"))
    println(stud_cbor)

    stud.students[1].name="this is ProtoBuf"
    writeBinaryFile("${path}new_$file_name.proto", encodeProtobuf(stud))
    val stud_proto=decodeProtobuf(readBinaryFile("${path}new_$file_name.proto"))
    print(stud_proto)
}

fun readFile(file_name:String)=File(file_name).readText()
fun writeFile(file_name:String,content:String)=File(file_name).writeText(content)
fun readBinaryFile(file_name: String)=File(file_name).readBytes()
fun writeBinaryFile(file_name: String, content: ByteArray)=File(file_name).writeBytes(content)