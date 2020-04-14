package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val m = Integer.valueOf(minute)
        val h = Integer.valueOf(hour)
        var s = StringBuilder()
        val arr = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
                "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine")
        if (h > 12 || m > 59) return ""
        when (minute) {
            "00" -> return arr[h - 1] + " o' clock"
            "30" -> return "half past ${arr[h - 1]}"
            "15" -> return "quarter past ${arr[h - 1]}"
            "45" -> return "quarter to ${arr[h]}"
        }
        if (m <= 20) s.append(arr[m - 1])
        else if (m < 30) s.append(arr[((m / 10) * 10) - 1] + " " + arr[m % 10 - 1])
        if (m in 40..59) s.append(arr[60 - m - 1])
        else if (m > 30) s.append(arr[(((60 - m) / 10) * 10) - 1] + " " + arr[(60 - m) % 10 - 1])
        if (m < 30) s.append(" minutes past ${arr[h - 1]}")
        else if (m in 31..59) s.append(" minutes to ${arr[h]}")
        return s.toString()
    }
}



