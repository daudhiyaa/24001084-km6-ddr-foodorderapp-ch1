package model

open class App {
    open fun printAuthor() {
        println("""
            ====================
            A Kotlin Application
            ====================
        """.trimIndent())
    }
}