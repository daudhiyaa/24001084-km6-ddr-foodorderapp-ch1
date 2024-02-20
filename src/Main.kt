
import java.text.NumberFormat
import java.util.*

class App(private var author : String) { // argument in constructor
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

    private var userChoice = 0

    fun run() {
        printAuthor()
        printListFood()
        chooseFood()
        enterPayment()
        printListDeliveryMethod()
        chooseDelivery()
    }

    private fun printAuthor() {
        println("================================")
        println("Food Order Application")
        println("Created By : $author")
        println("================================")
    }

    private fun printListFood () {
        println("\nList Menu :")
        foodMenu.forEachIndexed { index, data ->
            println("${index + 1}. ${data.foodName} ${data.foodPriceInString}")
        }
    }

    private fun chooseFood(){
        print("\nPilih Menu Makanan (Pilih Angkanya) : ")
        try {
            userChoice = readln().toInt() - 1

            // if index out of range
            if(userChoice < 0 || userChoice > 4) {
                println("Angka Melewati Batas Index!")
                chooseFood()
            }

            println("Kamu memilih menu $userChoice")
            println("Nama Menu\t: ${foodMenu[userChoice].foodName}")
            println("Harga\t\t: ${foodMenu[userChoice].foodPriceInString}")
        } catch (e : Exception) {
            println("Mohon Hanya Masukkan Angka!")
            chooseFood()
        }
    }

    private fun enterPayment() {
        print("\nMasukkan Nominal Pembayaran : ")
        try {
            val userInp = readln().toInt()
            if(userInp < foodMenu[userChoice].foodPrice) {
                println("Maaf, pembayaran Anda gagal!")
                println("* Nominal Pembayaran Anda Kurang")
                enterPayment()
            } else {
                println("Terima kasih, Anda berhasil memesan makanan")

                // convert number to currency format
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("IDR")

                println("Kembalian Anda : ${format.format(userInp - foodMenu[userChoice].foodPrice)} ")
            }
        } catch (e : NumberFormatException) {
            println("Mohon Hanya Masukkan Angka!")
            enterPayment()
        }
    }

    private fun printListDeliveryMethod() {
        println("\nMetode Pengiriman Makanan")
        println("1. Take Away\n" +
                "2. Delivery")
    }

    private fun chooseDelivery(){
        print("\nPilih Metode Pengiriman Makanan (Pilih Angkanya) : ")
        try {
            val userInp = readln().toInt()

            // if index out of range
            if (userInp > 2) {
                println("Angka Melewati Batas Index!")
                chooseDelivery()
            }
            // if choose take-away
            else if (userInp == 1) {
                waiting("Makananmu sedang dimasak (5 detik) ", 5)
                waiting("Makananmu sudah siap! Silakan ambil di resto ya! (5 detik) ", 5)
                waiting("Pesanan selesai! (3 detik) ", 3)
            }
            // if choose delivery
            else if (userInp == 2){
                waiting("Makananmu sedang dimasak (5 detik) ", 5)
                waiting("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) ", 5)
                waiting("Driver sampai! Pesanan selesai! (3 detik) ", 3)
            }
        } catch (e : NumberFormatException) {
            println("Mohon Hanya Masukkan Angka!")
            chooseDelivery()
        }
    }

    private fun waiting(msg : String, durationInSecond : Int) {
        print(msg)
        for (i in 1..durationInSecond) { // waiting 'n' seconds
            val startTime = System.currentTimeMillis() // fetch starting time
            while((System.currentTimeMillis()-startTime) < 1000) {
                // waiting each second
            }
            print(".")
        }
        println()
    }
}

fun main() {
    val app = App("Daud Dhiya' Rozaan")
    app.run()
}