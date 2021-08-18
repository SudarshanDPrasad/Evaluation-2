import java.util.*


fun main() {
    val Scanner = Scanner(System.`in`)
    print("Enter the Amount To be paid  = ")
    val Amount = Scanner.nextInt()

    if (Amount > 300) {
        var toDiscount = Amount - (Amount * 0.90)
        if(toDiscount<100) {
            print("The Total Amount to be paid is ${Amount - toDiscount}")
        }else {
            print("The Total Amount to be paid is ${Amount-100}")
        }
    }else {
        print("The Total Amoubt to be paid is $Amount")
    }
}