class Computer {

    var mBoard: String? = null
    var mDisplay: String? = null
    var mOS: String? = null

    class Builder {

        private val computer = Computer()

        fun setBoard(board: String): Builder = this.apply {
            computer.mBoard = board
        }

        fun setDisplay(display: String): Builder = this.apply {
            computer.mDisplay = display
        }

        fun setOS(os: String): Builder = this.apply {
            computer.mOS = os
        }

        fun create(): Computer = computer

    }

}

val computer = Computer.Builder()
    .setBoard("1")
    .setDisplay("2")
    .setOS("3")
    .create()

