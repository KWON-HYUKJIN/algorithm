// 피보나치 수열
// index 0 1 2 3 4 5 6 7
// value 0 1 1 2 3 5 8 13

fun main() {
    // println(recursive(7))

    println(dp(7))
}

fun recursive(n: Int): Int {
    // 종료
    // 0 or 1
    if (n <= 1) {
        return n
    }
    return recursive(n - 1) + recursive(n - 2)
}

// 시간복잡도 O(n)
fun dp(n: Int): Int {
    val array = IntArray(n + 1)
    array[0] = 0
    array[1] = 1

    for (i in 2..n) {
        array[i] = array[i - 1] + array[i - 2]
    }

    return array[n]
}
