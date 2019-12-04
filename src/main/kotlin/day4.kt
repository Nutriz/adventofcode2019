
fun main() {
    val twoConsecutiveNumbersRegex = Regex("([0-9])\\1")
    val onyIncreaseOrSame = Regex("^(?=\\d{6}\$)1*2*3*4*5*6*7*8*9*\$")

    val (rangeStart, rangeEnd) = inputsDay4.split("-").map(String::toInt)
    val result = (rangeStart..rangeEnd).filter { pwd: Int ->
        twoConsecutiveNumbersRegex.containsMatchIn(pwd.toString()) && onyIncreaseOrSame.containsMatchIn(pwd.toString())
    }.size

    println(result)
}

val inputsDay4 = "402328-864247"