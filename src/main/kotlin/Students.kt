import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.protobuf.ProtoBuf

@Serializable
data class Students(var students:Array<Student>)
@Serializable
data class Student(var name:String, var group:String, var grades:Array<Grade>)
@Serializable
data class Grade(var subject:String, var mark:Int)

//JSON
fun decodeJson(strudents: String):Students=Json.decodeFromString<Students>(strudents)
fun encodeJson(students: Students):String=Json.encodeToString(students)
//CBOR
fun decodeCbor(students: ByteArray):Students=Cbor.decodeFromByteArray<Students>(students)
fun encodeCbor(students: Students):ByteArray=Cbor.encodeToByteArray(students)
//ProtoBuff
fun decodeProtobuf(students: ByteArray):Students=ProtoBuf.decodeFromByteArray<Students>(students)
fun encodeProtobuf(students: Students):ByteArray=ProtoBuf.encodeToByteArray(students)
