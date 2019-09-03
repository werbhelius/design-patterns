/**
 * 命令模式：将一个请求封装成一个对象，使行为调用者与实现者解偶
 */

class TetrisMachine {

    fun toLeft() {
        println("向左")
    }

    fun toRight() {
        println("向右")
    }

    fun fastToBottom() {
        println("快速落下")
    }

    fun transform() {
        println("改变形状")
    }

}

interface Command {

    fun execute()

}

class leftCommand(val tetrisMachine: TetrisMachine): Command{

    override fun execute() {
        tetrisMachine.toLeft()
    }

}

class rightCommand(val tetrisMachine: TetrisMachine): Command{
    override fun execute() {
        tetrisMachine.toRight()
    }

}

class ToBottomCommand(val tetrisMachine: TetrisMachine): Command{
    override fun execute() {
        tetrisMachine.fastToBottom()
    }

}

class transformCommand(val tetrisMachine: TetrisMachine): Command{
    override fun execute() {
        tetrisMachine.transform()
    }
}

class Button(val leftCommand: leftCommand,
             val rightCommand: rightCommand,
             val toBottomCommand: ToBottomCommand,
             val transformCommand: transformCommand) {

    fun toLeft() = leftCommand.execute()
    fun toRight() = rightCommand.execute()
    fun fastToBottom() = toBottomCommand.execute()
    fun transform() = transformCommand.execute()

}

fun main() {

    val tetrisMachine = TetrisMachine()

    val button = Button(leftCommand(tetrisMachine), rightCommand(tetrisMachine), ToBottomCommand(tetrisMachine), transformCommand(tetrisMachine))

    button.toLeft()

}