class Person(val firstName: String = "Ra", val lastName: String = "Kri"){

    var nickName: String? = null
        get(){
            println("Nickname is $field")
            return field;
        }
        set(value) {
            field = value
            println("Setter is called")
        }

    fun printPersonInfo(){
        var nickNameToPrint = nickName ?: "no nick name"

        println("$firstName ($nickNameToPrint) $lastName")
    }
}