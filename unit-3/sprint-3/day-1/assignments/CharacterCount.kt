fun main() {

        val arr = arrayOf("HTML", "CSS", "JAVA", "JS", "ANDROID")
        var count = 0
        for (i in arr.indices) {
            val length = arr[i].length
            count = count + length
        }
        println(count)
    }
