fun main(){
    var arr = arrayOf(0)
    var sum =0;
    if(arr.size>0){

        print(Average(arr))

    }else {
        print("0")
    }
}

fun Average(arr: Array<Int>): Int {

    var sum=0;
    for(element in arr) {
        sum += element
    }
    var average = sum/arr.size
    return average;
}
