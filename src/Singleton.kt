
object Singleton

class Singleton2 private constructor() {

    companion object {

        @Volatile private var INSTANCE: Singleton2? = null

        fun getInstance(): Singleton2  =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Singleton2().also { INSTANCE = it }
                }

    }

}

