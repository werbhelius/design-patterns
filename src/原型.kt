/**
 * 原型模式本质就是对象拷贝，实现保护性拷贝，使一个对象对外只读
 */
class User(val name: String, var age: String): Cloneable {

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): User {
        return super.clone() as User
    }

}

data class User2(val name: String, val age: String)


fun main() {
    val user1 = User("aaa", "12")
    val user2 = user1.clone()

    user2.age = "1"

    println(user1.age)
    println(user2.age)
}