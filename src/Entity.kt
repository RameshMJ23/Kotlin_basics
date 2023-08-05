import java.util.*
import kotlin.concurrent.fixedRateTimer

interface IdProvider{
    fun getId(): String
}

enum class EntityType{
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory{
    fun createEntity(type: EntityType): Entity{
        val id = UUID.randomUUID().toString()

        val name = when(type){
            EntityType.HELP -> type.getFormattedName()
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> type.getFormattedName()
        }

        return when(type){
            EntityType.HELP -> Entity.help
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
        }
    }
}

sealed class Entity{

    object help: Entity(){
        val helpVar = "help"
    }

    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
}

fun Entity.Medium.printInfo(){
    println("Medium extension function: $id")
}

val Entity.Medium.newValue
    get() = "new Value"

fun main() {
    val entity = EntityFactory.createEntity(EntityType.MEDIUM)

    (entity as Entity.Medium).printInfo()

    (entity as Entity.Medium).newValue
}