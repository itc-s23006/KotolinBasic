package org.example

import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {
    // Check03 で作ったプログラムが、本当に確率通りか試してみる
    print("試行回数?: ")
    val count = readln().toInt()

    // かち・まけ・あいこ の数を数える変数を用意する
    var win = 0
    var lose = 0
    var draw = 0

    for (i in 0..<count) {
        val player = Random.nextInt(1..3)
        println("1:グー 2:チョキ 3:パー を選びました: $player")

        // 乱数で勝敗を決める
        val (result, judge) = when (Random.nextInt(0..<100)) {
            in 0..<10 -> {
                win++
                Pair(1, "かち")
            }
            in 10..<15 -> {
                draw++
                Pair(0, "あいこ")
            }
            else -> {
                lose++
                Pair(2, "まけ")
            }
        }
        // CPUの手を計算で求める
        val cpu = (player + result) % 3

        // 結果表示
        // 勝敗の結果表示(プレイヤー視点)
        println("CPU: ${cpu + 1} --- $judge")
    }
    println("確率の結果")
    println("かち: $win (${win / count.toDouble() * 100}%)")
    println("まけ: $lose (${lose / count.toDouble() * 100}%)")
    println("あいこ: $draw (${draw / count.toDouble() * 100}%)")
}