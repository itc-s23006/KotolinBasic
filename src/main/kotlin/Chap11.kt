package org.example

fun main(args: Array<String>) {
    val age = 19
    var message = ""

    message = if (age in 0..19) {
        "未成年です"
    } else {
        "成人です"
    }

    println(message)
}