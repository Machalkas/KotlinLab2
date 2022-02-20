import java.io.File

val file_name="students"
val path="./src/main/files/"
fun main() {
    val stud=decodeJson(readFile("$path$file_name.json"))
    print(stud)
    stud.students[0].name="Василий" //Изменяем имя первого студента
    for (st in stud.students){
        for (gr in st.grades) {
            if(gr.subject=="history") gr.mark=4 //Изменяем все оценки по истории на 4
        }
    }
    writeFile("${path}new_$file_name.json",encodeJson(stud))//сохраняем в json файл

    stud.students[1].name="this is Cbor"//Изменяем имя второго студента
    writeBinaryFile("${path}new_$file_name.cbor",encodeCbor(stud))//сохраняем в бинарный файл в формате CBOR
    val stud_cbor=decodeCbor(readBinaryFile("${path}new_$file_name.cbor"))
    println("read from cbor file: $stud_cbor")

    stud.students[1].name="this is ProtoBuf"//Изменяем имя второго студента
    writeBinaryFile("${path}new_$file_name.proto", encodeProtobuf(stud))//сохраняем в бинарный файл в формате Protocol Buffer
    val stud_proto=decodeProtobuf(readBinaryFile("${path}new_$file_name.proto"))
    print("read from proto file: $stud_proto")
}
fun readFile(file_name:String)=File(file_name).readText()
fun writeFile(file_name:String,content:String)=File(file_name).writeText(content)
fun readBinaryFile(file_name: String)=File(file_name).readBytes()
fun writeBinaryFile(file_name: String, content: ByteArray)=File(file_name).writeBytes(content)