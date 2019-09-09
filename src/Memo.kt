/**
 * 备忘录模式：用于保存对象的当前状态，并且在之后可以再恢复到此状态
 */

class CallOfDuty {

    private var mCheckPoint = -1
    private var mLifrValue = 100
    private var mWeapon = "沙漠之鹰"

    fun play() {
        println("玩游戏：第${mCheckPoint}关")
        mLifrValue -= 10
        println("进度升级")
        mCheckPoint ++
        println("到达：第${mCheckPoint}关")
    }

    fun quit() {
        println("----------")
        println("退出前的游戏属性：$this")
        println("退出游戏")
        println("----------")
    }

    fun createMemo(): Memo = Memo().apply {
        this.mCheckPoint = this@CallOfDuty.mCheckPoint
        this.mLifrValue = this@CallOfDuty.mLifrValue
        this.mWeapon = this@CallOfDuty.mWeapon
    }

    fun restore(memo: Memo) {
        this.mCheckPoint = memo.mCheckPoint
        this.mLifrValue = memo.mLifrValue
        this.mWeapon = memo.mWeapon
        println("恢复游戏属性")
    }


}

class Memo {

    var mCheckPoint = -1
    var mLifrValue = 100
    var mWeapon = "沙漠之鹰"

}

class CareTaker {
    private var memo: Memo? = null

    fun archive(memo: Memo) {
        this.memo = memo
    }

    fun getMemo() = memo

}

fun main() {
    val game = CallOfDuty()
    game.play()
    val careTaker = CareTaker()
    careTaker.archive(game.createMemo())
    game.quit()
    val newGame = CallOfDuty()
    newGame.restore(careTaker.getMemo() ?:return)
}