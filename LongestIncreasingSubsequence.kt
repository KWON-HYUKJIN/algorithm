// 수열의 가장 긴 부분수열 찾기(길이)
// 5, 6, 3, 4, 7, 2, 10, 1, 5, 7, 8, 2
// 5개 -> 3, 4, 5, 7, 8

// 동적계획법으로 진행
// * 마지막 값 비교

// Array [5, 6, 3, 4, 7, 2, 10, 1, 5, 7, 8, 2]
// L     [1, 2, 1, 2, 3, 1,  4, 1, 3, 4, 5, 2]
// index가 10일떄 값은 8입니다.
// 배열에서 값이 8 보다 작은 값들(i가 0~9의 값들)은 5, 6, 3, 4, 7, 2, 1, 5, 7이 있습니다.
// 이들중에 가장 큰값은 7이며 i는 9입니다. L(9)는 4입니다.
// 8의 이전 마지막값은 7이며 길이가 4입니다. 따라서 값 8포함시(+1) 길이는 5입니다. 

fun main() {    
    println(
        lis(intArrayOf(5, 6, 3, 4, 7, 2, 10, 1, 5, 7, 8, 2))
    )
}

fun lis(arr: IntArray): Int {
    val temp = IntArray(arr.size)
    temp[0] = 1

    // O(n^2)
    for (i in 1 until arr.size) {
        var n = 0
        for (j in 0 until i) {
            if (arr[j] < arr[i] && temp[j] > n) {
                n = temp[j]
            }
        }
        temp[i] = n + 1
    }

    var max = 1
    for ((index, value) in temp.withIndex()) {
        if (max < value) {
            max = value
        }
    }
    return max
}
