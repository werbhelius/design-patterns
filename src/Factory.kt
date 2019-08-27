/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪个类
 */
abstract class Product {

    abstract fun method()

}

class ProductA : Product() {
    override fun method() {
        println("this is ProductA")
    }
}

class ProductB : Product() {
    override fun method() {
        println("this is ProductB")
    }
}

class ProductC : Product() {
    override fun method() {
        println("this is ProductB")
    }
}

class Factory {

    fun <T : Product> createProduct(clz: Class<T>): Product {
        return Class.forName(clz.name).newInstance() as T
    }

}

fun main() {

    Factory().createProduct(ProductB::class.java).method()
    Factory().createProduct(ProductA::class.java).method()

}