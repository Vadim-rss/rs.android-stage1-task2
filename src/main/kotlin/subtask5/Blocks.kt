package subtask5

import kotlin.reflect.KClass
import java.time.format.DateTimeFormatter
import java.time.LocalDate

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        if (blockB == Int::class){
            var blockC: Int = 0
            blockA.forEach{if(it is Int) blockC += it}
            return (blockC)
        }

        if (blockB == String::class){
            var blockC: String = ""
            blockA.forEach{if (it is String) blockC += it}
            return (blockC)
        }

        if (blockB == LocalDate::class){
            var blockC: LocalDate = LocalDate.parse("0001-01-01")
            blockA.forEach{if (it is LocalDate) if (blockC < it) blockC = it}
            return (blockC.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
        }
        throw NotImplementedError("Not implemented")
    }
}
