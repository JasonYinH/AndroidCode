package com.base.one_code_three_version

import com.base.one_code_three_version.two.*
import kotlin.math.max

var content: String? = "hello"
fun main() {
    print("第一行diamante")
    val a = 10
    val b = 20
    val value = largerNumber(a, b)
    print("larger number is$value")
    //kotlin 关键字
    //左右闭区间 ..  [0,10]
    for (i in 0..10) {
        println("---> ..$i")
    }
    //左闭右开 until  [0,10) 不包括10
    for (i in 0 until 10) {
        println("---> 左闭右开$i")
    }
    //降序 downTo
    for (i in 10 downTo 0) {
        println("--->降序 $i")
    }
    //区间范围内递增 2
    for (i in 0..10 step 2) {
        println("---> $i")
    }
//    val p = Person()
//    p.name = "JasonYin"
//    p.age = 24
//    p.eat()
    //继承和构造函数
    val s = Student("学号", 66, "JasonYin", 24)
    println("---> s is$s")
    val s1 = Student()
    println("---> s1 is$s1")
    val s2 = Student("jj", 24)
    println("---> s2 is$s2")
    //实现接口  面向接口编程
    doHomeStudy(s2)

    //----------2.5.4 数据类与单例类-----------------
    //数据类 data关键字
    val c1 = CallPhone("奔驰", 22.55)
    val c2 = CallPhone("奔驰", 22.55)
    println("---> $c1")
    println("--->c1 equals c2 ${c1 == c2}")
    //单例类
    Singleton.singletonTest()
    SingletonJava.getInstance().singletionTest()
    //------------------2.6 Lambda编程-------------------------
    val list = listOf("Apple", "Banana", "Orange")
    for (i in list) {
        println("--->list 不可变集合$i")
    }
    val listm = mutableListOf("Apple", "Banana", "Orange")
    listm.add("Pear")
    for (i in listm) {
        println("--->list可变集合 $i")
    }
    val set = setOf("Apple", "Banana", "Orange")
    for (i in set) {
        println("--->set 不可变集合$i")
    }
    val map = mapOf("APPle" to 1, "Banana" to 2, "Orange" to 3)
    for ((i, j) in map) {
        println("--->map不可变 i is $i j is $j")
    }
    val mapm = mutableMapOf("APPle" to 1, "Banana" to 2, "Orange" to 3)
    mapm["JUZI"] = 4
    for ((i, j) in mapm) {
        println("--->map可变 i is $i j is $j")
    }
    val map1 = listm.map { it.toUpperCase() }
    for (i in map1) {
        println("--->转为大写 $i")
    }
    //函数式API
    //过滤filter
    val filter = listm.filter { it.length <= 5 }
        .map { it.toLowerCase() }
    println("---> 过滤并转为小写 $filter")
    //any 判断集合中至少一个元素满足指定条件的  all  判断集合中所有元素满足指定条件的
    val any = listm.any { it.length <= 5 }
    val all = listm.all { it.length <= 5 }
    println("---> any is $any all is $all")

    if (content != null) {
        privateUpperCase()
    }
    //let函数
    doHomeStudy(null)

}

fun privateUpperCase() {
    val map = content!!.map { it.toUpperCase() }
    println("---> $map")
}

fun doHomeStudy(study: Study?) {
//    study?.readBooks()
//    study?.doHomework()
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}

fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

