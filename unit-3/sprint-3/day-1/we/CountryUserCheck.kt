import java.util.*

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val Countries: MutableList<String> = ArrayList()
        for (i in 0..10) {
            Countries.add(sc.nextLine())
        }
        println("Enter the country to check")
        val check = sc.next()
        if (Countries.contains(check)) {
            println("Found")
        } else {
            println("Not Found")
        }
    }
