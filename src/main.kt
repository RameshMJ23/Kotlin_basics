import kotlin.text.StringBuilder

fun greetFunc(greeting: String = "Hello", vararg itemList: String) {
    itemList.forEach{
        item -> println("$greeting $item")
    }
}


fun main(){

    val person = Person()

    person.firstName
    person.lastName

    person.printPersonInfo()
}