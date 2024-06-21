import kotlin.random.Random
import kotlin.system.exitProcess

fun main() { // 数字を当てるゲーム。
    val choiceNumber = Random.nextInt(1, 101) // 1から100までのランダムな数字を1つ生成。(正解の数字。)
    var inputContent: Int // 入力内容
    var numberOfTimes = 0 // 試行した回数をカウント。
    val maximumNumberOfAttempts = 5 // 最大試行回数

    println("1から100までの数字を当ててください！")

    while (true) { // 数字が当たるまで繰り返す。
        val remainingAttempts = maximumNumberOfAttempts - numberOfTimes // remainingAttempts -> 残りの試行回数。
        val lives = "*".repeat(remainingAttempts) // lives -> 残機　残機を"*"で表示。
        print("あなたの予想 (残機: $lives): ")
        val input = readLine() // 入力内容を読み取る。

        // 入力がnullまたは数字でない場合のチェック。
        if (input == null || input.toIntOrNull() == null) {
            println("有効な数字を入力してください。")
            continue
        }

        inputContent = input.toInt()
        numberOfTimes++ // 試行するたびに、numberOfTimesを追加。

        when {
            inputContent < choiceNumber -> println("もっと大きい数字です。") // 入力した数字が正解の数字より大きい場合、出力。
            inputContent > choiceNumber -> println("もっと小さい数字です。") // 入力した数字が正解の数字より小さい場合、出力。
            else -> { // 数字があたったら、出力。何回目で当たったか表示。
                println("ゲームクリア！ $numberOfTimes 回目の試行で正解です。")
                exitProcess(0) // ゲームを終了。
            }
        }

        if (numberOfTimes >= maximumNumberOfAttempts) { // 試行回数が最大に達したらゲームオーバー。
            println("ゲームオーバー! 正解は $choiceNumber でした。")
            exitProcess(0)
        }
    }
}
