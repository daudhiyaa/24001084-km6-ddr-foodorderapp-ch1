package controller

import java.text.NumberFormat
import java.util.*
import constant.foodMenu
import model.App

class FoodApp(private var author : String?) : App() { // argument in constructor
    private var userChoice = 0

    fun run() {
        printAuthor()
        printListFood()
        chooseFood()
        enterPayment()
        printListDeliveryMethod()
        chooseDelivery()
    }

    override fun printAuthor() {
        println("================================")
        println("Food Order Application")
        author?.let {
            println("Created By : $author")
        } ?: run {
            println("This program is Open Source")
        }
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

            // if index out of range, choose food again
            if(userChoice !in foodMenu.indices) {
                println("Angka Melewati Batas Index!")
                chooseFood()
            }
            else {
                println("Kamu memilih menu ke-${userChoice + 1}")
                println("Nama Menu\t: ${foodMenu[userChoice].foodName}")
                println("Harga\t\t: ${foodMenu[userChoice].foodPriceInString}")
            }
        } catch (e : NumberFormatException) {
            println("Mohon Hanya Masukkan Angka!")
            chooseFood()
        }
    }

    private fun enterPayment() {
        print("\nMasukkan Nominal Pembayaran : ")
        try {
            val userInp = readln().toInt()
            val userFoodPrice = foodMenu[userChoice].foodPrice

            // if payment nominal < food price, enter payment nominal again
            if(userInp < userFoodPrice) {
                println("Maaf, pembayaran Anda gagal!")
                println("* Nominal Pembayaran Anda Kurang")
                enterPayment()
            } else {
                println("Terima kasih, Anda berhasil memesan makanan")

                // formatting number to currency
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("IDR")

                println("Kembalian Anda : ${format.format(userInp - userFoodPrice)} ")
            }
        } catch (e : NumberFormatException) {
            println("Mohon Hanya Masukkan Angka!")
            enterPayment()
        }
    }

    private fun printListDeliveryMethod() {
        println("")
        println("""
            Metode Pengiriman Makanan
            1. Take Away
            2. Delivery
        """.trimIndent())
    }

    private fun chooseDelivery(){
        print("\nPilih Metode Pengiriman Makanan (Pilih Angkanya) : ")
        try {
            val userInp = readln().toInt()

            // if choose take-away
            if (userInp == 1) {
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
            // if index out of range
            // choose again delivery method
            else {
                println("Angka Melewati Batas Index!")
                chooseDelivery()
            }
        } catch (e : NumberFormatException) {
            println("Mohon Hanya Masukkan Angka!")
            chooseDelivery()
        }
    }

    private fun waiting(msg : String, durationInSecond : Int) {
        print(msg)
        for (i in 1..durationInSecond) { // waiting 'n' seconds
            Thread.sleep(1000)
            print(".")
        }
        println()
    }
}