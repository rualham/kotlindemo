package com.android.car.myfirstkotlindemo

data class MyUser(var name: String, val age: Int) {

}

fun main(args: Array<String>) {
    val jack = MyUser("Jack", 1)
    val jack2 = MyUser(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 3)
    println(jack)
    println(jack2)
    println(olderJack)
    val jane = MyUser("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age")
}