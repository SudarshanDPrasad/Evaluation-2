import java.util.*

object LeapYear {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val leapyear = sc.nextInt()
        if (leapyear % 4 == 0) {
            if (leapyear % 100 == 0) {
                if (leapyear % 400 == 0) {
                    println("leapyear")
                } else {
                    println("not a leap year")
                }
            } else {
                println("leapyear")
            }
        } else {
            println("not a leap year")
        }
    }
}