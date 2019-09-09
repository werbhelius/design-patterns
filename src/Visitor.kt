import java.util.*

/**
 * 访问者模式，封装一下用于某种数据结构中各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作
 */

abstract class Staff {
    var name: String = ""
    val kpi: Int
        get() = Random().nextInt(100)

    abstract fun accept(visitor: Visitor)
}

abstract class Visitor {

    abstract fun visit(engineer: Engineer)

    abstract fun visit(manager: Manager)

}

class Engineer: Staff() {

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    fun getCodeLines() = Random().nextInt(10)

}

class Manager: Staff() {

    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    fun getProducts() = Random().nextInt(10)

}

class CEOVisitor: Visitor() {

    override fun visit(manager: Manager) {
        println("产品经理---${manager.kpi}")
    }

    override fun visit(engineer: Engineer) {
        println("工程师---${engineer.kpi}")
    }
}

class CTOVisitor: Visitor() {

    override fun visit(engineer: Engineer) {
        println("工程师---${engineer.getCodeLines()}")
    }

    override fun visit(manager: Manager) {
        println("产品经理---${manager.getProducts()}")
    }
}

class BusinessReport {

    private val list = arrayListOf<Staff>().apply {
        add(Manager())
        add(Engineer())
        add(Engineer())
        add(Engineer())
    }

    fun showReport(visitor: Visitor){
        list.forEach {
            it.accept(visitor)
        }
    }

}

fun main() {
    val businessReport = BusinessReport()
    businessReport.showReport(CEOVisitor())
    businessReport.showReport(CTOVisitor())
}