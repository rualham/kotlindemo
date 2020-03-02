package com.android.car.myfirstkotlindemo

class DontCreateMe constructor(name: String) {

    var url: String = "https://www.lvmama.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站：${name}")
    }

    constructor(name: String, alexa: Int) : this(name) {
        println("Alexa排名$alexa")
    }
}

fun main(args: Array<String>) {
    var runno1 = DontCreateMe("runn1")
    var runno2 = DontCreateMe("fdafaf",20)
    println(runno1.country)
    println(runno1.siteName)
    println(runno2.siteName)
}