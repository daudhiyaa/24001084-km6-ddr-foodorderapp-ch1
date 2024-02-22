class ControlFlowExample {
    fun run() {
        println(checkNameUsingIfElse("puji astuti"))
        println(checkNameUsingWhen("Jupyter"))
        checkName()
        checkContentType()
    }

    private fun checkNameUsingIfElse(name : String?) : String {
        return if(name == null)
            "Your Name is still Empty"
        else if(name.contains("pUJi", ignoreCase = true))
            "Namamu mengandung 'puji', tanpa peduli kapital/tidak"
        else
            "Namamu adalah $name"
    }

    private fun checkNameUsingWhen(planet : String) : String {
        return when(planet) {
            "Mercury", "Venus" -> "This is planet before earth"
            "Earth" -> "This is our planet"
            else -> "This is not planet"
        }
    }

    private var name: String? = "Mee"
    private fun checkName(){
        if(name == null) return // escape condition
        println(name)
    }

    private fun checkContentType () {
        val contentType = ContentType.PHOTO
        when(contentType) {
            ContentType.PHOTO -> println("Ini Photo")
            ContentType.VIDEO -> println("Ini Video")
            ContentType.REELS -> println("Ini Reels")
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFlowExample().run()
        }
    }
}

enum class ContentType {
    PHOTO, VIDEO, REELS
}