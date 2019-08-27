
object Singleton

class Singleton2 private constructor() {

    companion object {

        @Volatile private var INSTANCE: Singleton2? = null

        fun getInstance(): Singleton2  =
                INSTANCE ?: synchronized(this) {
                    // 因为编译器允许处理器乱序执行，所以需要在此判空
                    INSTANCE ?: Singleton2().also { INSTANCE = it }
                }

    }

}

