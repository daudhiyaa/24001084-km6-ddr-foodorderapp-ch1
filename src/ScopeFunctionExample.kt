class ScopeFunctionExample {
    private val author : String? = null
    private var food : FoodMenu? = FoodMenu(
        "Ayam Bakar",
        "Rp 50.000/porsi",
        50000
    )

    fun run() {
        // let & apply is similar, only best practice

        // let => biasanya utk melakukan sesuatu
        author?.let {
            println("Created By : $author")
        } ?: run {
            println("This program is Open Source")
        }

        // apply => biasanya utk ngeset sesuatu
        food?.apply {
            this.foodName = "Rib Eye Crispy"
        } ?: run {
            println("Food is null")
        }

        // with
        with(food!!){
            println(foodName)
            println(foodPrice)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}