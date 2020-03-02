package com.android.car.myfirstkotlindemo

import java.lang.reflect.Type
import java.util.concurrent.locks.Lock
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

enum class Color {
    RED, BLACK, BLUE, GREEN, WHITE
}

enum class Color1(val rgb: Int) {
    RED(0X454),
    GREEN(0x45)
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState

}

enum class RGB { RED, GREEN, BLUE }


inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

open class EA(x: Int) {
    public open val y: Int = x
}

interface EB {

}

val ab: EA = object : EA(1), EB {
    override val y = 11
}

class AC {
    //私有函数，其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    //公有函数，其返回类型是Any
    fun fooo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x
//        val x2 = fooo().
    }
}

/*
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ……
    }

    val allDataProviders: Collection<DataProvider>
        get() = // ……
}*/
object Site {
    var url: String = ""
    val name: String = "菜鸟"
}

class MyGreatClass {
    companion object {
        fun create(): MyGreatClass = MyGreatClass()
    }
}

val instance1 = MyGreatClass.create()
val instance2 = MyGreatClass.Companion

interface Factory<T> {
    fun create(): T
}

class MyLittleClass {
    companion object : Factory<MyLittleClass> {
        override fun create(): MyLittleClass = MyLittleClass()
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(b: Base) : Base by b

class Example {
    var p: String by Delegate()
}


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef , 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("$thisRef 的${property.name}属性赋值为$value")
    }
}

fun main(args: Array<String>) {
    /*  EnumClass.valueOf(value:String):EnumClass
      on
      EnumClass.values(): Array<EnumClass>*/
    var color: Color = Color.BLUE
    println(Color.values())
    println(Color.valueOf("RED"))
    println(color.name)
    println(color.ordinal)
    printAllValues<RGB>()
    val site = object {
        var name: String = "大菜鸟"
        var url: String = "lvmama"
    }
    println("我是分割线")
    println("site.name${site.name}")
    println(site.url)
    var s1 = Site
    var s2 = Site
    s1.url = "jflsadfkasjfl"
    println(s1.url)
    println(s2.url)
    val b = BaseImpl(10)
    Derived(b).print()
    val e = Example()
    println(e.p)//访问该属性，调用getvalue()函数

    e.p = "Runnob"
    println(e.p)
    println(lazyValue) // 第一次执行，执行两次输出表达式
    println(lazyValue)// 第二次执行，只输出返回值

    val yourUser = YourUser()
    yourUser.name = "第一次赋值"
    yourUser.name = "第二次赋值"
    val mySite = MySite(mapOf(
            "name" to "菜鸟课程",
            "url" to "mylvmama"
    ))
    println(mySite.name)
    println(mySite.url)
    val foo = MyFoo()
    foo.notNullBar = "myBar"
    println(foo.notNullBar)
    var ui = MyUI()
    println(ui.image)
    println(ui.text)
}

inline fun <T> check(lock: Lock, noinline body: () -> T): T {
    lock.lock()
    try {
        otherCheck(body)//会报错,说内联的参数需要被声明为noinline的才可以传给其他函数
        return body()
    } finally {
        lock.unlock()
    }
}

fun <T> otherCheck(body: () -> T) {
    println("check $body")
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
    "fadfdjka"
}

class YourUser {
    var name: String by Delegates.observable("初始值") { prop, old, new ->
        println("旧值:$old->新值:$new")
    }
}

class MySite(val map: Map<String, Any>) {
    val name: String by map
    val url: String by map
}

class MyFoo {
    var notNullBar: String by Delegates.notNull<String>()
}

class ResourceID() {
    val image_id: String = "101"
    val text_id: String = "102"
}

class ResourceLoader(id: ResourceID) {
    val d: ResourceID = id
    operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>): ReadOnlyProperty<MyUI, String> {
        if (checkProperty(thisRef, prop.name)) {
            return DellImpl(d)
        } else {
            throw Exception("Error ${prop.name}")
        }
    }

    private fun checkProperty(thisRef: MyUI, name: String): Boolean {
        return name.equals("image") || name.equals("text")
    }
}

class DellImpl(d: ResourceID) : ReadOnlyProperty<MyUI, String> {
    val id: ResourceID = d
    override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        if (property.name.equals("image"))
            return property.name + "  " + id.image_id
        else
            return property.name + "  " + id.text_id
    }
}

fun bindResource(id: ResourceID): ResourceLoader {
    var res = ResourceLoader(id);
    return res
}

class MyUI {
    val image by bindResource(ResourceID())
    val text by bindResource(ResourceID())
    //val webview by bindResource(ResourceID())
}



