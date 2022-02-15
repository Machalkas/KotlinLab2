fun main() {
    val st = Students()
    st.decode("""{"name":"Vasia", "group":"p124"}""")
    st.name="Вася"
    println(st.encode())

}