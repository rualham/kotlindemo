package com.android.car.myfirstkotlindemo

class Personal(val student: String = "ham") {
    var lastName: String = "zhang"
        get() = field.toUpperCase() // 将变量赋值后转换为大写
        set
    var no: Int = 100
        get() = field    //后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
    var height: Float = 145.4f
        private set

    lateinit var subject: String


}

fun main(args: Array<String>) {
    var person: Personal = Personal()
    person.lastName = "wang"
}