/**
 * 模版方法：定义抽象类并且声明一些抽象基本方法供子类实现不同逻辑，同时在抽象类中定义具体方法把抽象基本方法封装起来
 */

abstract class Template {

    abstract fun powerOn()

    abstract fun checkHardware()

    abstract fun loadOS()

    abstract fun login()

    fun startUp() {
        powerOn()
        checkHardware()
        loadOS()
        login()
    }

}

class CoderTemple: Template() {
    override fun powerOn() {
        println("程序员开机")
    }

    override fun checkHardware() {
        println("程序员检查硬件")
    }

    override fun loadOS() {
        println("程序员加载系统")
    }

    override fun login() {
        println("程序员登录")
    }

}

class TeacherTemple: Template() {
    override fun powerOn() {
        println("老师开机")
    }

    override fun checkHardware() {
        println("老师检查硬件")
    }

    override fun loadOS() {
        println("老师加载系统")
    }

    override fun login() {
        println("老师登录")
    }

}

fun main() {
    var template: Template = CoderTemple()
    template.startUp()
    template = TeacherTemple()
    template.startUp()
}