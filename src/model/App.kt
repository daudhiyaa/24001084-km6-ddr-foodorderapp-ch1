package model

open class App {
    open fun run() {
        printAuthor()
    }

    open fun printAuthor() {
        println("""
            ====================
            A Kotlin Application
            ====================
        """.trimIndent())
    }
}