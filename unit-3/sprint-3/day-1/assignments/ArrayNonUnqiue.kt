
    fun main() {
        val arr = intArrayOf(10, 10, 20, 20, -20)
        var check = false
        for (i in arr.indices) {
            check = false
            for (j in arr.indices) {
                if (arr[i] != arr[j]) {
                    check = false
                } else {
                    if (arr[i] == arr[j] && i != j) {
                        check = true
                        break
                    }
                }
            }
            if (check) println(arr[i])
        }
    }
