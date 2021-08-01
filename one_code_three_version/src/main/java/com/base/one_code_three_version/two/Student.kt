package com.base.one_code_three_version.two

class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    init {
        println("---> sno is $sno\n grade is $grade")
        println("---> ${eat()}")
    }

    //次构造函数 constructor
    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    constructor() : this("", 0) {

    }

    override fun readBooks() {
        println("--->$name is readBooks")
    }

    override fun doHomework() {
        println("---> $name is doHomework")
    }
}