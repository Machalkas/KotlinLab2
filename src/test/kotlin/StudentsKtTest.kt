import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.system.measureTimeMillis
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EncodeTest{
    val iterations=10
    val stud=decodeJson(readFile("${path}test_$file_name.json"))
    val file=File("encodeTest.txt").bufferedWriter()
    var avg=0.0
    @AfterAll
    fun cleanup(){
        print("cleanup")
        file.close()
    }
    @BeforeEach
    fun prepare(){
        avg=0.0
    }
    @Test
    fun testJson(){
        file.write("JSON:\n")
        for(i in 1..iterations) {
            val millis = measureTimeMillis {
                encodeJson(stud)
            }
            avg+=millis
            file.write("Iteration $i time $millis ms\n")
        }
        file.write("Avg: ${avg/iterations}\n\n")
    }
    @Test
    fun testCbor(){
        file.write("CBOR:\n")
        for(i in 1..iterations) {
            val millis = measureTimeMillis {
                encodeCbor(stud)
            }
            avg+=millis
            file.write("Iteration $i time $millis ms\n")
        }
        file.write("Avg: ${avg/iterations}\n\n")
    }
    @Test
    fun testProtobuff(){
        file.write("Protobuff:\n")
        for(i in 1..iterations) {
            val millis = measureTimeMillis {
                encodeProtobuf(stud)
            }
            avg+=millis
            file.write("Iteration $i time $millis ms\n")
        }
        file.write("Avg: ${avg/iterations}\n\n")
    }
}