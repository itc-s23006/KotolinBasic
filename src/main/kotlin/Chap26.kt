package com.example.chap26

import java.time.LocalDate
import java.time.LocalDateTime

fun main(args: Array<String>) {
    // 書籍情報概要(BookInfo)がほしい (プライマリコンストラクタのみを使う場合)
    // 1.まずは Book がないと始まらない
    val book = Book(
        100,
        "やさしい Kotlin 入門",
        "野崎英一",
        LocalDate.of(2018, 5, 10)
    )
    // 2.貸出情報 Rental を作る
    val rental = Rental(
        book.id,
        "タケシ",
        LocalDateTime.now(),
        LocalDateTime.of(2024, 5, 28, 12, 30)
    )
    // 3.book と rental を合わせた BookWithRental を作る
    val bookWithRental = BookWithRental(
        book, rental
    )
    // 4.まとめた bookWithRental を使って BookInfo が作れる
    val bookInfo = BookInfo(
        bookWithRental.book.id,
        bookWithRental.book.title,
        bookWithRental.book.author,
        bookWithRental.isRental
    )
    // 5.中身を表示
    bookInfo.printInfo()

    // 4.2 別パターン
    val bookInfo2 = BookInfo(
        book.id,
        book.title,
        book.author,
        true
    )
    // 4.3 理想的なパターン
    val bookInfo3 = BookInfo(bookWithRental)
}

class BookInfo(
    val id: Long,           // Bookクラスの id と同じ
    val title: String,      // Bookクラスの title と同じ
    val author: String,     // Bookクラスの author と同じ
    val isRental: Boolean   // BookWithRental の isRental と同じ
) {
    constructor(bookWithRental: BookWithRental) : this(
        bookWithRental.book.id,
        bookWithRental.book.title,
        bookWithRental.book.author,
        bookWithRental.isRental
    )

    fun printInfo() {
        println(
            """
            [ID:${id}] $title (${author})
            ${if (isRental) "貸出中です" else "貸出可能です"}
        """.trimIndent()
        )
    }
}

class Book(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
)

class Rental(
    val bookId: Long,
    val userName: String,
    val rentalDateTime: LocalDateTime,
    val returnDeadline: LocalDateTime,
)

class BookWithRental(
    val book: Book,
    val rental: Rental?
) {
    val isRental: Boolean
        get() = rental != null
}