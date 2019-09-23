/**
 * 外观模式：要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行，统一接口封装，将子系统的逻辑、交互隐藏起来。
 */

interface Phone {

    fun dail()

    fun hangup()

}

class PhoneImpl: Phone {

    override fun dail() {
        println("打电话")
    }

    override fun hangup() {
        println("挂电话")
    }

}

interface Camera {

    fun open()
    fun takePicture()
    fun close()

}

class CameraImpl: Camera {

    override fun open() {
        println("打开相机")
    }

    override fun takePicture() {
        println("照相")
    }

    override fun close() {
        println("关闭相机")
    }
}

class MobilePhone {

    private val phone = PhoneImpl()
    private val camera = CameraImpl()

    fun dail() {
        phone.dail()
    }

    fun takePhoto() {
        camera.open()
        camera.takePicture()
    }

    fun closeCamera() {
        camera.close()
    }

}

fun main() {
    val nexus6 = MobilePhone()
    nexus6.dail()
}