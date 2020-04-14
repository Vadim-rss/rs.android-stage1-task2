package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val numbers = IntArray(26){0}
        numbers[1] = 1
        var result = IntArray(3){1}

        for(i in 2..numbers.size-1){
            numbers[i] = numbers[i-1] + numbers[i-2]
        }
        for(i in 0..numbers.size-2){
            if(numbers[i]*numbers[i+1] == n){
                result[0] = numbers[i]
                result[1] = numbers[i+1]
            }
            if(numbers[i]*numbers[i+1] > n && numbers[i]*numbers[i-1] < n){
                result[0] = numbers[i]
                result[1] = numbers[i+1]
                result[2] = 0
            }
        }
        return result
    }
}