
    fun main(args: Array<String>) {
        val arr = intArrayOf(10, 20, 30, 10, 40, -2, 30)
        var check = false
        for (i in arr.indices) {
            check = false
            for (j in arr.indices) {
                if (arr[i] != arr[j]) {
                    check = true
                } else {
                    if (arr[i] == arr[j] && i != j) {
                        check = false
                        break
                    }
                }
            }
            if (check) println(arr[i])
        }
    }
