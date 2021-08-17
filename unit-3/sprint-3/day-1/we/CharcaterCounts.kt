import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main(){
    val sc = Scanner(System.`in`)
    val s = sc.nextLine()
    val Hashmap = java.util.LinkedHashMap<Char,Int>()
    for(element in s){
        val ch = element
        if(!Hashmap.containsKey(ch)){
            Hashmap[ch] = 1
        }else {
            val temp=Hashmap[ch]!!
            Hashmap[ch] = temp+1
        }
    }
    print(Hashmap)
}