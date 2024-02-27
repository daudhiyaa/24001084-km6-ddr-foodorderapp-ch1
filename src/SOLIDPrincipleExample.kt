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

/* Dependency Inversion */
class FirebaseAnalytics() {
    fun log(e: String){
        println("Logging to Firebase : Event Name : $e")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}

class NewRelicAnalytics() {
    fun log(e: String){
        println("Logging to New Relic : Event Name : $e")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}

class MoEngageAnalytics() {
    fun log(e: String){
        println("Logging to Mo Engage : Event Name : $e")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}

interface Analytics {
    fun log(e: String)
}

// === Agnostic Class ===
/*
* Klo cuman mau firebase, nanti newRelic sama moEngage disini diapus aja yg di bagian sini
* */
class AppAnalytics : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()
    private var moEngageAnalytics = MoEngageAnalytics()

    override fun log(e: String) {
        firebaseAnalytics.log(e)
        newRelicAnalytics.log(e)
        moEngageAnalytics.log(e)
    }
}

class LoginPage(private val analytics: Analytics) {
    fun openPage(pageName: String) {
        println("Open $pageName Page...")
        analytics.log(pageName)
    }
}

class HomePage(private val analytics: Analytics) {
    fun openPage(pageName: String) {
        println("Open $pageName Page...")
        analytics.log(pageName)
    }
}

class App {
    private val analytics = AppAnalytics()

    fun run () {
        LoginPage(analytics).openPage("Login")
        HomePage(analytics).openPage("Home")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}