package com.android.car.myfirstkotlindemo

open class YourPerson(var name: String) {
    constructor(name: String, age: Int) : this(name) {
        println("-----基类次级构造函数--------")
    }

    open fun study() {
        println("我毕业了")
    }
}

class MyStudent : YourPerson {
    constructor(name: String, score: Int, age: Int) : super(name, age) {
        println("-----继承类次级构造函数--------")
        println("学生名： ${name}")
        println("学生名： ${age}")
        println("学生名： ${score}")
    }

    override fun study() {
        super.study()
        super<YourPerson>.study()
        println("我上大学了")
    }
}

fun main(args: Array<String>) {
    var s = MyStudent("Runno", 98, 15)
    s.study()
    C().f()
    var c = Child()
    c.bar()
    c.foo()
//    User("Ham").name
    User("Ham").Print()
    val l = mutableListOf<Int>(1, 2, 3)
    l.swap(0, 1)
    l.swap(0, 2)
    println(l.toString())
    printFoo(D())
}

interface Foo {
    val count: Int
}

class Bar(override val count: Int) : Foo
class Bar2 : Foo {
    override var count: Int = 0
}

open class A {

    open fun f() {
        println("A")
    }

    fun a() {
        println("a")
    }
}

interface B {
    fun f() {
        println("B")
    }

    fun b() {
        println("b")
    }
}

class C : A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f()
        println("C")
    }
}

interface MyInterface {
    fun bar()
    fun foo() {
        //可选的方法体
        println("foo")
    }
}

class Child : MyInterface {
    override fun bar() {
        println("bar")
    }
}

class User(var name: String)

fun User.Print() {
    println("用户名1${name}")
    println("用户名2$name")
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

open class E

class D: E()

fun E.foo() = "c"   // 扩展函数 foo

fun D.foo() = "d"   // 扩展函数 foo

fun printFoo(c: E) {
    println(c.foo())  // 类型是 C 类
}