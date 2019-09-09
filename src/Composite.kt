/**
 * 组合模式：将对象组合成树形结构以表示"部分-整体"的层次结构，使得用户对单个对象和组合对象的使用具有一致性
 */

abstract class Component(val name: String) {

    abstract fun doSomgthing()

}

class Composite(name: String) : Component(name) {

    private val list = arrayListOf<Component>()

    override fun doSomgthing() {
        println(name)
        list.forEach {
            it.doSomgthing()
        }
    }

    fun addChild(component: Component) {
        list.add(component)
    }

    fun removeChild(component: Component) {
        list.remove(component)
    }

    fun getChildren(index: Int) = list[index]
}

class Leaf(name: String) : Component(name) {

    override fun doSomgthing() {
        println(name)
    }
}

fun main() {

    val root = Composite("root")

    val branch1 = Composite("branch1")
    val branch2 = Composite("branch2")

    val leaf1 = Leaf("Leaf1")
    val leaf2 = Leaf("Leaf2")

    branch1.addChild(leaf1)
    branch2.addChild(leaf2)

    root.addChild(branch1)
    root.addChild(branch2)

    root.doSomgthing()

}