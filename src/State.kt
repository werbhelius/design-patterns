/**
 * 拥有一组行为和不同的状态，不同状态下行为不一样，状态模式：抽象状态基类，实例化不同状态对象，是其拥有不同行为，对象直接是平行关系，不可替换
 */

abstract class TVState {

    abstract fun openTV()

    abstract fun closeTV()

    abstract fun switchShow()

}

class OpenTVState: TVState() {

    override fun closeTV() {
        println("关机")
    }

    override fun switchShow() {
        println("切换电视台")
    }

    override fun openTV() {

    }
}

class CloseTVState: TVState() {

    override fun openTV() {
        println("开机")
    }

    override fun closeTV() {
    }

    override fun switchShow() {
    }

}

interface Controller {

    fun open()

    fun close()

}

class TVController: Controller {

    lateinit var state: TVState

    private fun setTVState(state: TVState) {
        this.state = state
    }

    override fun open() {
        setTVState(OpenTVState())
        println("开机")
    }

    override fun close() {
        setTVState(CloseTVState())
        println("关机")
    }

    fun switchShow() {
        state.switchShow()
    }

}

fun main() {

    val controller = TVController()
    controller.open()
    controller.switchShow()
    controller.close()
    controller.switchShow()

}