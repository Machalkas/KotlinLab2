import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.system.measureTimeMillis
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EncodeTest {
    val iterations = 30
    val stud = decodeJson(readFile("${path}test_$file_name.json"))
    val file = File("encodeTest.txt").bufferedWriter()
    var avgEncode = 0.0
    var avgDecode = 0.0

    @AfterAll
    fun cleanup() {
        print("cleanup")
        file.close()
    }

    @BeforeEach
    fun prepare() {
        avgEncode = 0.0
        avgDecode = 0.0
    }

    @Test
    fun testJson() {
        file.write("JSON:\n")
        print("JSON:\n")
        for (i in 1..iterations) {
            var st:String
            val eMillis = measureTimeMillis {
                st = encodeJson(stud)
            }
            avgEncode += eMillis
            val dMillis = measureTimeMillis {
                decodeJson(st)
            }
            avgDecode+=dMillis
            file.write("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
            print("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
        }
        file.write("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
        print("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
    }

    @Test
    fun testCbor() {
        file.write("CBOR:\n")
        print("CBOR:\n")
        for (i in 1..iterations) {
            var st:ByteArray
            val eMillis = measureTimeMillis {
                st = encodeCbor(stud)
            }
            avgEncode += eMillis
            val dMillis = measureTimeMillis {
                decodeCbor(st)
            }
            avgDecode+=dMillis
            file.write("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
            print("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
        }
        file.write("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
        print("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
    }

    @Test
    fun testProtobuff() {
        file.write("Protobuff:\n")
        print("Protobuff:\n")
        for (i in 1..iterations) {
            var st:ByteArray
            val eMillis = measureTimeMillis {
                st = encodeProtobuf(stud)
            }
            avgEncode += eMillis
            val dMillis = measureTimeMillis {
                decodeProtobuf(st)
            }
            avgDecode+=dMillis
            file.write("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
            print("Iteration $i | Encode time $eMillis ms; Decode time $dMillis ms;\n")
        }
        file.write("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
        print("Avg: encode ${avgEncode / iterations}; decode ${avgDecode / iterations};\n\n")
    }
}