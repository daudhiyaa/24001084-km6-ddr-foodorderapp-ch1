import java.text.NumberFormat
import java.util.*

class App(private var author : String) { // argument in constructor
    private val fruitList = listOf(
        Fruit(
            "Melon",
            20000
        ),
        Fruit(
            "Apple",
            6000
        ),
        Fruit(
            "Mango",
            10000
        ),
        Fruit(
            "Avocado",
            8000
        ),
        Fruit(
            "Watermelon",
            21000
        ),
    )

    private var userChoice = 0

    fun run() {
        printAuthor()
        printListFruit()
        chooseFruit()
        howManyFruit()
    }

    private fun printAuthor() {
        println("================================")
        println("Welcome to Fruit Store")
        println("Created By : $author")
        println("================================")
    }

    private fun printListFruit () {
        println("\nOur Fruits Today :")
        fruitList.forEachIndexed { index, data ->
            println("${index + 1}. ${data.name} ${data.price}")
        }
    }

    private fun chooseFruit(){
        print("\nWhat do you want to buy (1/2/3/4/5) : ")
        try {
            userChoice = readln().toInt() - 1

            // if index out of range
            // choose food again
            if(userChoice !in fruitList.indices) {
                println("Index out of Bound!")
                chooseFruit()
            } else {
                println("You select : ${fruitList[userChoice].name}")
                println("........................")
            }
        } catch (e :  NumberFormatException) {
            println("Please enter only number!")
            chooseFruit()
        }
    }

    private fun howManyFruit() {
        println("\nHow many ${fruitList[userChoice].name} you wanna buy?")
        try {
            val userInp = readln().toInt()

            // if index out of range
            if(userInp < 1) {
                println("Must be a positive number")
                howManyFruit()
            } else {
                val totalPrice = fruitList[userChoice].price * userInp

                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("IDR")

                println("Total price : ${format.format(totalPrice)}")

                if(totalPrice in 100000..<150000){
                    println("You got extra 1 Watermelon")
                } else if (totalPrice in 150000..<200000) {
                    println("You got extra 2 Melon")
                } else if (totalPrice in 200000..<250000) {
                    println("You got extra 6 Avocado")
                } else if (totalPrice >= 25000) {
                    println("You got extra 1kg Apple")
                }
            }
        } catch (e :  NumberFormatException) {
            println("Please enter only number!")
            howManyFruit()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App("Daud Dhiya' Rozaan").run()
        }
    }
}