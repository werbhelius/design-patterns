/**
 * 适配器：把一个类的接口变成客户端所期待的另一种接口，从而使原本因接口而不匹配而无法在一起工作的两个类能够在一起工作
 */

interface Target {

    fun getVolt5(): Int

}

class Volt220 {

    fun getVolt220() = 220

}

class Adapter(private val volt220: Volt220) : Target {

    override fun getVolt5(): Int {
        return 5
    }

    fun getVolte220(): Int {
        return volt220.getVolt220()
    }
}

fun main() {
    val adapter = Adapter(Volt220())
    adapter.getVolt5()
}