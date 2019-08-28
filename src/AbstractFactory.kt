/**
 * 抽象工厂模式，在普通工厂的基础上进一步将工厂抽象，产生一类型产品
 */
abstract class Mouse

abstract class Keyboard

class AMouse: Mouse()

class BMouse: Mouse()

class AKeyoard: Keyboard()

class BKeyoard: Keyboard()

abstract class AbstractFactory {

    abstract fun creatMouse(): Mouse

    abstract fun createKeyboard(): Keyboard

}

class AFactor: AbstractFactory() {

    override fun createKeyboard(): Keyboard = AKeyoard()

    override fun creatMouse(): Mouse = AMouse()

}

class BFactor: AbstractFactory() {

    override fun createKeyboard(): Keyboard = BKeyoard()

    override fun creatMouse(): Mouse = BMouse()

}

fun main() {

    val a = AFactor()
    val b = BFactor()

}