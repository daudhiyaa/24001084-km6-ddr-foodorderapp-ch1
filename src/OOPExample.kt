interface Baloon {
    fun blow()
}

class RedBaloon() : Baloon {
    override fun blow() {
        println("Blow Baloon")
    }
}

abstract class HotBaloon() : Baloon { // implement
    override fun blow() {
        println("Blow Hot Baloon")
    }

    abstract fun carryPassenger()
}

class RedHotBaloon : HotBaloon() { // extend
    override fun carryPassenger() {
        println("carry Pass")
    }

    // overloading
    fun carryPassennger(name: String) {
        println(name)
    }
}

open class Processor(val name: String) {
    open fun initProcessor() {
        println("Initialize $name")
    }
}

class AMDProcessor() : Processor("Ryzen7") {
    override fun initProcessor() {
        println("Initialize Processor : $name")
    }
}

/* Open - Closed Principle */
open class IronManSuit() {
    // opened function
    open fun blast() {
        println("Blast using Iron Man Suit")
    }

    // closed function
    fun activateJarvis() {
        println("Jarvis is activated")
        Thread.sleep(1000)
    }
}

class WarMachineSuit() : IronManSuit () {
    override fun blast() {
        println("Blast using War Machine Suit")
    }
}

/* main function */
fun main() {
    RedHotBaloon().let {
        it.carryPassennger("Daud")
        it.carryPassenger()
    }
    AMDProcessor().initProcessor()
}