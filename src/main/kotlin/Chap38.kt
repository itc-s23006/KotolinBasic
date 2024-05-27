package com.example.chap38

fun main(args: Array<String>) {
    println("----38.1----")
    val c1 = getTextClosure("さん")
    val c2 = getTextClosure("くん")
    val c3 = getTextClosure("ちゃん")

    val name1 = c1("タケシ")
    val name2 = c2("タケシ")
    val name3 = c3("タケシ")

    println(name1)
    println(name2)
    println(name3)

    println("----38.3----")
    val closure = getCountlosure()
    println("クロージャーが返した値　= " + closure())
    println("クロージャーが返した値　= " + closure())
    println("クロージャーが返した値　= " + closure())
    println("----38.4----")
    val closureA = getCountlosure()
    val closureB = getCountlosure()
    println("クロージャーAが返した値　= " + closureA())
    println("クロージャーAが返した値　= " + closureA())
    println("クロージャーAが返した値　= " + closureA())
    println("クロージャーBが返した値　= " + closureB())
    println("クロージャーBが返した値　= " + closureB())
    println("クロージャーAが返した値　= " + closureA())
}

fun getTextClosure(x: String): (String) -> String {
    val caller: (String) -> String = fun(name: String) = name + x
    return caller
}

fun getCountlosure(): () -> Int {
    var num = 0
    val c: () -> Int = fun() : Int{
        num++
        return num
    }
    return c
}