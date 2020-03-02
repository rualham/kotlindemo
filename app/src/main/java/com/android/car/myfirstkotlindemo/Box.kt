package com.android.car.myfirstkotlindemo

class Box<T>(t: T) {
    var value = t
}

//val box: Box<Int>=Box<Int>(1)
val box1 = Box(1)

class MyBox<T>(t: T) {
    var value = t
}

fun <T : Comparable<T>> sort(list: List<T>) {

}

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

class Runoob<in A>(a: A) {
    fun foo(a: A) {
    }
}

class DA<T>(val t1: T, val t2: T, val t3: T)
class Apple(var name: String)

fun main(args: Array<String>) {
    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runno")
    println(boxInt.value)
    println(boxString.value)
    sort(listOf(1, 2, 3))

    /* var strCo: Runoob<String>=Runoob("a")
     var antCo: Runoob<Any>=Runoob<Any>("b")*/
    var strDCo = Runoob("a")
    var anyDCo = Runoob<Any>("b")
    strDCo = anyDCo
    //使用类
    val a1: DA<*> = DA(12, "String", Apple("评估"))
    val a2: DA<Any> = DA(12, "String", Apple("苹果"))//和a1一样
    val apple = a1.t3
    println("apple${apple}")
    val apple2 = apple as Apple
    println(apple2.name)
    //使用数组
    val l: ArrayList<Any> = arrayListOf("String", 1, 1.2f, Apple("苹果"))
    for (item in l) {
        println(item)
    }
}