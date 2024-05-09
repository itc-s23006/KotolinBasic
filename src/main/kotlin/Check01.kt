package org.example

fun main(args: Array<String>) {
    print("点数を入力してください: ")
    val score = readln().toInt()

    // 成績判定
    println("----パターン1----")
    if (score < 0 || score > 100) { // それ(0～100)以外は「エラー」と出力
        println("エラー")
    } else if (score < 60) { // 0 ～ 59 は D
        println("D")
    } else if (score < 70) { // 60 ～ 69 は C
        println("C")
    } else if (score < 80) { // 70 ～ 79 は B
        println("B")
    } else if (score < 90) { // 80 ～ 89 は A
        println("A")
    } else { // 90 ～ 100 は S
        println("S")
    }

    println("----パターン2----")
    val rank2 = if (score !in 0..100) { // それ(0～100)以外は「エラー」と出力
        "エラー"
    } else if (score < 60) { // 0 ～ 59 は D
        "D"
    } else if (score < 70) { // 60 ～ 69 は C
        "C"
    } else if (score < 80) { // 70 ～ 79 は B
        "B"
    } else if (score < 90) { // 80 ～ 89 は A
        "A"
    } else { // 90 ～ 100 は S
        "S"
    }
    println(rank2)

    println("----パターン3----")
    val rank3 = when (score) {
        !in 0..100 -> "エラー"
        in  0..<  60 -> "D"
        in 60..<  70 -> "C"
        in 70..<  80 -> "B"
        in 80..<  90 -> "A"
        else           -> "S"
    }
    println(rank3)

    println("----パターン4----")
    val rank4 = when (score) {
        in  0..<  60 -> "D"
        in 60..<  70 -> "C"
        in 70..<  80 -> "B"
        in 80..<  90 -> "A"
        in 90..100 -> "S"
        else -> "エラー"
    }
    println(rank4)
}