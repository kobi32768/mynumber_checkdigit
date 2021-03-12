fun main() {
    println("Enter your My Number of Japan\n" +
            "(All are processed LOCALLY)")

    val input = readLine()!!

    // -- format check -- //
    if (input.toLongOrNull() == null) {
        println("Not a number")
        return
    }

    val mynumber = when (input.length) {
        11 -> { input.reversed() }
        12 -> { input.reversed().drop(1) }
        else -> {
            println("Invalid length")
            return
        }
    }

    // -- calculate -- //
    var sigma = 0
    for (n in 1..11) {
        val Qn = when (n) {
            in 1..6  -> n+1
            in 7..11 -> n-5
            else -> return // reluctantly
        }
        sigma += mynumber[n-1].toString().toInt() * Qn
    }

    var CD = 11 - ( sigma % 11 )
    if (CD in 10..11) { CD = 0 }

    println("CheckDigit: $CD")
}
