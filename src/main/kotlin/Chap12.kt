package org.example

fun main(args: Array<String>) {
    val x = 2

    when {
        (x == 1 || x == 2)
                -> println("１か２のどちらか")
        (x == 3)
                -> println("３")
        else
            -> println("１，２，３以外の数字")
    }
}