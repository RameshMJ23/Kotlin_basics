class FancyInfoProvider: BasicInfoProvider() {

    override val sessionIdPrefix: String
        get() = "......Fancy info session ID....."

    override fun printInfo(person: Person) {
        println("......Fancy info provider.....")
        super.printInfo(person)
    }


}