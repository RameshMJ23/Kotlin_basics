
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?){
    list.forEach{
        if (predicate?.invoke(it) == true){
            println(it)
        }
    }
}

val predicateFunc: (String) -> Boolean = {
    it.startsWith("C")
}

fun getPredicateFunction(): (String) -> Boolean{
    return {
        it.startsWith("C")
    }
}

fun main() {

    val list = listOf("Kotlin", "C++", "Java", "Javascript")

    printFilteredStrings(list, getPredicateFunction())
}