package practice

import FoodMenu

class LoopingExample {
    private val foodMenu = listOf(
        FoodMenu(
            "Ayam Bakar",
            "Rp 50.000/porsi",
            50000
        ),
        FoodMenu(
            "Ayam Goreng",
            "Rp 40.000/porsi",
            40000
        ),
        FoodMenu(
            "Ayam Geprek",
            "Rp 40.000/porsi",
            40000
        ),
        FoodMenu(
            "Kulit Ayam Crispy",
            "Rp 15.000/porsi",
            15000
        ),
        FoodMenu(
            "Sate Usus Ayam",
            "Rp 5.000/porsi",
            5000
        ),
    )

    fun run () {
        printSomething()
    }

    private fun printSomething() {
        for (i in 1..5 step 2) {
            println("ini looping dengan +=2")
        }

        for (i in 5 downTo 1 step 2) {
            println("ini looping dengan -=2")
        }

        for(i in foodMenu.indices) {
            println("${i + 1} :")
            println("- ${foodMenu[i].foodName}")
            println("- ${foodMenu[i].foodPriceInString}")
        }

        // do-while
        var idx = 0
        do {
            println(idx)
            idx++
        } while (idx < 5)

        // while
        while (idx < 10){
            println(idx)
            idx++
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LoopingExample().run()
        }
    }
}