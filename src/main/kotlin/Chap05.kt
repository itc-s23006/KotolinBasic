package org.example

fun main(args: Array<String>) {
    val k: String = "Kotlin"
    val message = """
        |こんにちは、世界！
        |私は　${k}に関して勉強しています。
        |${k}では、とても簡潔なプログラムを書くことができます。
        |皆さん、一緒に楽しくプログラミングしましょう！
        """.trimMargin()

    println(message)
}