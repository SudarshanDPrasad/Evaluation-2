fun main(){
    var sum=0;
    for(i:Int in 0..10){
        if(i%3==0){
            sum += i;
        }
    }
    print(sum)
}