/**
 * 迭代器模式：提供一种方法顺序访问一个容器对象中的各个元素，而又不需要暴露该对象的内部表示
 */

interface Iterator<T> {

    fun hasNext(): Boolean

    fun next(): T?

}

class ConcreteIterator<T>(private val list: ArrayList<T>) : Iterator<T> {

    private var cursor = 0

    override fun hasNext(): Boolean {
        return cursor != list.size
    }

    override fun next(): T? {
        var obj: T? = null
        if (this.hasNext()) {
            obj = list[cursor++]
        }
        return obj
    }

}

interface Aggregate<T> {

    fun add(t: T)

    fun remove(t: T)

    fun iterator(): Iterator<T>
}

class ConcreteAggregate<T> : Aggregate<T> {

    private val list = arrayListOf<T>()

    override fun add(t: T) {
        list.add(t)
    }

    override fun remove(t: T) {
        list.remove(t)
    }

    override fun iterator(): Iterator<T> {
        return ConcreteIterator(list)
    }

}

fun main() {
    val aggregate: Aggregate<String> = ConcreteAggregate()
    aggregate.add("1")
    aggregate.add("2")
    aggregate.add("3")
    val iterator = aggregate.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
}

