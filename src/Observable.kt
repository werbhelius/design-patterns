import java.util.*

/**
 * 观察者：定义对象间一种一对多的依赖的关系，使得每当一个对象改变状态，则所有依赖于它的对象都会被得到通知并被自动更新
 */

class Coder : Observer {

    override fun update(o: Observable?, arg: Any?) {
        println("更新啦")
    }

}

class Publish: Observable() {

    fun postNews() {
        setChanged()
        notifyObservers()
    }

}

fun main() {
    val publish = Publish()
    publish.addObserver(Coder())
    publish.postNews()
}