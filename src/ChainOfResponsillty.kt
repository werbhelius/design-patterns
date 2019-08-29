/**
 * 是多个对象处理请求，并将这些对象形成一条链，并沿着该链传递请求，知道有对象处理它为止，具有层级传递关系，避免请求发送者与接受者的耦合关系。
 */

abstract class AbstractHandler {

    var nextHandler: AbstractHandler? = null

    fun handlerRequest(request: AbstractRequest) {
        if (getHandlerLevel() >= request.getHandlerLevel()) {
            handler(request)
        } else {
            nextHandler?.also {
                it.handlerRequest(request)
            }
        }
    }

    abstract fun getHandlerLevel(): Int

    abstract fun handler(request: AbstractRequest)

}

abstract class AbstractRequest {

    abstract fun getHandlerLevel(): Int

}

class GroupHandler : AbstractHandler() {

    override fun getHandlerLevel(): Int = 1000

    override fun handler(request: AbstractRequest) {
        println("组长处理了${request.getHandlerLevel()}")
    }
}

class Director : AbstractHandler() {

    override fun getHandlerLevel(): Int = 5000

    override fun handler(request: AbstractRequest) {
        println("经理处理了${request.getHandlerLevel()}")
    }
}

class Boss : AbstractHandler() {

    override fun getHandlerLevel(): Int = Int.MAX_VALUE

    override fun handler(request: AbstractRequest) {
        println("老板处理了${request.getHandlerLevel()}")
    }
}

class People(private val money: Int) : AbstractRequest() {
    override fun getHandlerLevel(): Int = money
}

fun main() {

    val groupHandler = GroupHandler()
    groupHandler.apply {
        nextHandler = Director().apply {
            nextHandler = Boss()
        }
    }

    groupHandler.handlerRequest(People(10000))

}
