package org.example

import kotlin.random.Random
import kotlin.time.measureTime

fun main(args: Array<String>) {
    run {
        println("----18.1----")
        val s: Set<String> = setOf("あ", "い", "う", "え", "お")
        println(s)
    }
    run {
        println("----18.2----")
        val s = mutableSetOf("あ", "い", "う", "え", "お")
        s += "か"
        s += "き"
        s += "く"
        println(s)
    }
    run {
        println("----18.2+----")
        val s = mutableSetOf("あ", "い", "う", "え", "お")
        s += "か"
        s += "き"
        s += "く"
        s += "い"
        s += "お"
        s += "か"
        println(s)
    }

    println("----ListとSetの比較----")
    val dataSet = mutableSetOf<Int>()
    while (dataSet.count() < 10000) {
        dataSet += Random.nextInt()
    }
    val dataList = dataSet.toMutableList()

    val searchList = mutableListOf<Int>()
    for (i in 0..100_000) {
        searchList += Random.nextInt()
    }
    val repeat = 500

    val listTime = measureTime {
        for (r in 0..<repeat) {
            println("List ${r}セット目")
            for (s in searchList) {
                dataList.contains(s)
            }
        }
    }

    val setTime = measureTime {
        for (r in 0..<repeat) {
            println("Set ${r}セット目")
            for (s in searchList) {
                dataSet.contains(s)
            }
        }
    }
    println("Listの所要時間: $listTime")
    println(" Setの所要時間: $setTime")
}