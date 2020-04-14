package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val s = a.toUpperCase()
        val e = s.filter { s -> b.contains(s)}
        if(e == b){
            return "YES"}
        else
            return "NO"
    }
}
