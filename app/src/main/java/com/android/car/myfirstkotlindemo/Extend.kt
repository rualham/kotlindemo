package com.android.car.myfirstkotlindemo

class Extend {
    fun usage(baz: MainActivity) {
        baz.goo()
    }
}

class CD {
    fun bar() {
        println("CD bar")
    }
}

class CC {
    fun bar() {
        println("CC bar")
    }

    fun baz() {
        println("C baz")
    }

    fun CD.foo() {
        bar() // 调用 D.bar
        this@CC.bar()
        baz()// 调用 C.baz
    }

    fun caller(d: CD) {
        d.foo()//调用扩展函数
    }
}

fun main(args: Array<String>) {
    var c: CC = CC()
    var d: CD = CD()
    c.caller(d)

    DC().caller(DD()) // 输出 "DD.foo in C"
    DC1().caller(DD())// 输出 "D.foo in DC1" —— 分发接收者虚拟解析
    DC().caller(DD1())// 输出 "DD.foo in C" —— 扩展接收者静态解析
}

open class DD {

}

class DD1 : DD() {

}

open class DC {
    open fun DD.foo() {
        println("DD.foo in C")
    }

    open fun DD1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: DD) {
        d.foo()//调用扩展函数
    }
}

class DC1 : DC() {
    override fun DD.foo() {
        println("DD.foo in DC1")
    }

    override fun DD1.foo() {
        println("DD!.foo in C1")
    }
}

