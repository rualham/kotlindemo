package com.android.car.myfirstkotlindemo

class MyCompanionClass {

    companion object {
        val myClassField1: Int = 1
        val myClassField2 = "this is myClassField2"
        fun companionFun1() {
            println("this is 1st companion function")
            foo()
        }

        fun companionFun2() {
            println("this is 2rd companion function")
            companionFun1()
        }
    }

    fun MyCompanionClass.Companion.foo() {
        println("伴随对象的扩展函数（内部）")
    }

    fun getAddress(id: Int, name: String) = {
        //用“=”代替return，返回String类型则交给类型推断

        "got it" //return被“=”代替了

    }

    fun getMyAddress(id: Int, name: String): String { //用“=”代替return，返回String类型则交给类型推断

        return "got it" //return被“=”代替了

    }

    fun test2() {
        MyCompanionClass.foo()
    }

    init {
        test2()
    }
}

val MyCompanionClass.Companion.noo: Int
    get() = 100

fun MyCompanionClass.Companion.foo() {
    println("foo 伴随对象外部扩展函数")
}

fun main(args: Array<String>) {
    println("noo:${MyCompanionClass.noo}")
    println("field1:${MyCompanionClass.myClassField1}")
    println("field2:${MyCompanionClass.myClassField2}")
    MyCompanionClass.foo()
//    MyCompanionClass().test2()
    MyCompanionClass()
    MyCompanionClass.companionFun1()
    MyCompanionClass.companionFun2()
    val ints: ArrayList<Int> = arrayListOf(1, 2, 3, 4)
    val dints1 = ints.map { value -> value * 2 }
    val dints2 = ints.map { it * 3 }
    println("dints1" + dints1)
    println("dints2" + dints2)
}