/**
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。
 */
interface Strategy {

    fun calculatePrice(distance: Int): Int

}

class BusStrategy : Strategy {
    override fun calculatePrice(distance: Int): Int {
        return distance / 2
    }

}

class SubwayStrategy : Strategy {

    override fun calculatePrice(distance: Int): Int {
        return (distance / 2 + distance * 0.1).toInt()
    }

}

class TrafficCalculate {

    private lateinit var strategy: Strategy

    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun calculatePrice(distance: Int): Int {
        return strategy.calculatePrice(distance)
    }

}

fun main() {

    val trafficCalculate = TrafficCalculate().apply { setStrategy(SubwayStrategy()) }

    trafficCalculate.calculatePrice(1)

}