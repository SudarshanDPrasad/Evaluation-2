fun main(){
    val scores = arrayOf(10,20,1,2,25)

    var low = scores[0];

    for(i in scores){
        if(i<low){
            low=i
        }
    }
    print("Lowest Score is $low")
}