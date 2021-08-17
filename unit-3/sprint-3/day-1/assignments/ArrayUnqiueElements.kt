fun main(){
    var arr = arrayOf(10,20,30,10,40,-2,30)
    for(i in 0..arr.size){
        for (j in 0..arr.size){
            if(arr[i]==arr[j]){
                print(arr[i])
                break
            }
        }
    }
}