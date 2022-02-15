fun main() {
    val stud=decodeStudent("""{"name":"Vasia", "group":"p124"}""")
    stud.name="Вася"
    println(encodeStudent(stud))
}
