package com.android.car.myfirstkotlindemo

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sum(1, 3);
        printSum(1, 3);
        println(12345 + 1 + 2)
        println("a1234javaClass = ${javaClass}")

        var c: Int;
        c = 1;

        var x = 5;
        x += 1;

        var a = 1;
        println("a is")
        val s1 = "a is $a"
//        println(s1)

        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        println("s2=" + s2)
        //类型后面加?表示可为空
        var age: String? = "3"
        //抛出空指针异常
        val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
//        main(var Array{1,2});
        getStringLength("ddfadsasfa");
        getStringLength(1235);

        for (i in 1..4) println("for循环1 " + i)
        for (i in 4..1) println("for循环2 " + i)
        //todo
//        if (i in 1..10) { // 等同于 1 <= i && i <= 10
//            println(i)
//        }

        for (i in 1..4 step 3) println("for循环3 " + i)

        for (i in 4 downTo 1 step 3) println("for循环4 " + i)

        for (i in 1 until 10) {
            println("for循环5 " + i)
        }

        val oneMillion = 1_000_000
        var twoMillion = 2_000_000

        var ac: Int = 1000
//        var ac:Int=1
        println("值相等吗？");
        println(ac == ac);
        println(ac === ac); // true，值相等，对象地址相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = ac
        val anotherBoxedA: Int? = ac
        //虽然经过了装箱，但是值是相等的，都是10000
        println(boxedA === anotherBoxedA)//  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA)// true，值相等

        val b: Byte = 1
        val i: Int = b.toInt()
        var l = 1L + 3
        var r = "ggg"
        var d: Long = 45;
        d.shl(2)
        d.and(3);
        d.inv();
        main1(arrayOf(4, 5, 6))
        val xy: IntArray = intArrayOf(1, 2, 3)
        xy[0] = xy[1] + xy[2]
        val text = """ sa
              多行字符串1
              多行字符串2
               """.trimIndent()
        println(text)

        main2()
        chooseMax(25, 36)
        textView.setText("" + chooseMax(25, 36) + "fadf");
        textView.setOnClickListener { chooseMax(50, 100) }
    }

    fun main2() {
        val i = 10
        val s = "i = $i" // 求值结果为 "i = 10"
        println(s)

        var t = "runoob"
        var str = "$t.length is ${t.length}"
        println(str)
        val price = """${'$'}9.99"""
        val price1 = """$9.99"""
        println(price)
        println(price1)
    }

    //    fun sum(a: Int, b: Int): Int {
//        return a + b;
//    }
    public fun sum(a: Int, b: Int): Int = a + b;

    fun printSum(a: Int, b: Int): Unit {
        print(12346 + a + b);
    }

    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)
        }
    }

    fun lis(args: ArrayList<String>) {
        vars(1, 2, 3, 4, 5)
        args.map { println() }
        args.map(::println)
    }

    fun sum(args: Array<String>) {
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumLambda(1, 2))
    }

    fun main(args: Array<String>) {
        if (args.size < 2) {
            print("Two integers expected")
            return
        }
        val x = parseInt(args[0])
        val y = parseInt(args[1])
        if (x != null && y != null) {
            println(x * y)
        }
    }

    object Person {
        var name = "name"
    }

    fun getStringLength(obj: Any): String? {
        if (obj is String) {
            return "my length is" + obj.length;
        }
        if (obj !is String) {
            return "my length is" + obj;
        }
        return null;
    }

    fun main1(args: Array<Int>) {
        //[1,2,3]
        val a = arrayOf(1, 2, 3)
        //[0,2,4]
        val b = Array(3, { i -> (i * 2) })
        println(a[0])
        println(b[1])
        Person.name
    }

    fun chooseMax(a: Int, b: Int): Int {
        val max = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        print("ChooseMax" + max)
        if (a in 15..100) {
            println("x在区间内")
        }
        when (a) {
            0, 1 -> println("x==0 or x==1")
//            in 15..100 -> println("x在此区间范围内")
            else -> println("otherwise")
        }
        var items = listOf("apple", "banana", "pear")
        when {
            "orange" in items -> println("juice")
            "apple" in items -> println("fresh apple")
        }
        for (item in items) {
            println(item)
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
        return max;
    }
}
