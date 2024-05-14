package org.example

import kotlin.random.Random

fun main(args: Array<String>) {
    // 勝ちが1割、負けが8.5割 あいこ0.5割となる
    // CPUを実装したじゃんけんを作ってください

    print("１：グー　２：チョキ　３：パー　を選んでください：　")
    val player = readln().toInt() - 1

    // 乱数で勝敗を決める
    val result = when (Random.nextInt(0, 100)) {
        in 0..<10 -> 1
        in 10.. 15 -> 0
        else -> 2
    }

    // CPUの手を計算で求める
    val cpu = (player + result) % 3

    // 表示用の勝ち負けあいこ
    val judge = when(result) {
        0 -> "あいこ"
        1 -> "勝ち"
        else -> "負け"
    }

    //  結果表示
    // 複数の結果表示（プレイヤー視点）
    println("CPU: ${cpu + 1} --- $judge")
}