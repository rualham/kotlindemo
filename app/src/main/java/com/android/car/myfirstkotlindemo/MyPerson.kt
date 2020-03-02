package com.android.car.myfirstkotlindemo

open class MyPerson(var name: String, var age: Int) {
}

class Student(name: String, age: Int, var no: String, var score: Int) : MyPerson(name, age) {

}

fun main(args: Array<String>) {
    var s = Student("Runno", 18, "s12345", 97)
    println("学生名:${s.no}")
    println("学生分数:${s.score}")
}