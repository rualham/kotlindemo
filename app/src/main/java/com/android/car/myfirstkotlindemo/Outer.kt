package com.android.car.myfirstkotlindemo

class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    var ha: Int = 2
    val ha1: Int = 2

    inner class Inner {
        fun foo() = bar//访问外部成员变量
        fun innerTest() {
            var o = this@Outer//获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main(args: Array<String>) {
    val demo = Outer().Inner().foo()
    println(demo)
    val demo2 = Outer().Inner().innerTest()
    println(demo2)
    println(demo2)
    G().foo()
    var t = null;
    println(t.toString())
    MyCompanionClass.foo()
    println("${MyCompanionClass.no}")
}

class G {
    fun foo() {
        println("成员函数")
    }
}

fun G.foo() {
    println("扩张函数")
}

fun Any?.toString(): String {
    if (this == null) return "null+1"
    return toString()
}

class MyClass {
    companion object {

    }
}

/*fun MyCompanionClass.Companion.foo() {
    println("伴随对象的扩展函数")
}*/

val MyCompanionClass.Companion.no: Int
    get() = 100