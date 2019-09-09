/**
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问。场景：当无法或不想直接访问某个对象或访问某个对象有困难时，可以通过一个代理对象间接访问。
 */

abstract class Subject {

    abstract fun visit()

}

class RealSubject : Subject() {

    override fun visit() {
        println("Real subject")
    }

}

class ProxySubject(private val realSubject : RealSubject): Subject() {

    override fun visit() {
        realSubject.visit()
    }
}

fun main() {
    val realSubject = RealSubject()
    val proxy = ProxySubject(realSubject)
    proxy.visit()
}

