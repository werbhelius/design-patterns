/**
 * 装饰模式：使用一种对客户端透明的方式来动态扩展对象的功能，动态的给对象添加一些额外职责，是继承关系的一种替代方案。
 */

abstract class Person {

    abstract fun dressed()

}

class Boy: Person() {

    override fun dressed() {
        println("穿了一件衣服")
    }
}

abstract class PersonCloth(private val person: Person): Person() {

    override fun dressed() {
        person.dressed()
    }

}

class ExpensiveCloth(person: Person) : PersonCloth(person) {

    fun dressPants() {
        println("穿了裤子")
    }

    fun dressLeather() {
        println("穿了皮衣")
    }

    override fun dressed() {
        super.dressed()
        dressPants()
        dressLeather()
    }

}

class CheapCloth(person: Person) : PersonCloth(person) {

    fun dressShorts() {
        println("穿了短裤")
    }

    override fun dressed() {
        super.dressed()
        dressShorts()
    }

}

fun main() {
    val boy: Person = Boy()

    val exCloth = ExpensiveCloth(boy)
    exCloth.dressed()

    val cheapCloth = CheapCloth(boy)
    cheapCloth.dressed()
}