interface PersonInfoProvider {

    val providerInfo: String

    fun printInfo(person: Person){
        println(providerInfo)
        person.printPersonInfo()
    }
}

interface SessionInfoProvider{
    fun getSessionId(): String
}

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider{

    override val providerInfo: String
        get() = "Basic Info Provider"

    protected open val sessionIdPrefix: String = "Session ID"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Additional info")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

}

fun main(){
    val provider = object : PersonInfoProvider{
        override val providerInfo: String
            get() = "Anonymous provider info"

        fun getSessionId(): String{
            return "Anon session id"
        }
    }

    provider.printInfo(Person("Ramesh", " Krishnan"))
    println(provider.getSessionId())
}

fun checkTypes(provider: PersonInfoProvider){
    if(provider is SessionInfoProvider){
        println("Is a session info provider")
        provider.getSessionId()
    }else{
        print("It is not a session info provider")
    }
}