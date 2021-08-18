import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val Countries = arrayOf("India", "Aus", "England", "Canada", "India", "USA", "USA", "Japan", "China", "UK")
    val Name = sc.nextLine()
    for (i in Countries.indices) {
        if (Countries[i] == Name) {
            println("$Name $i")
        }
    }
}
