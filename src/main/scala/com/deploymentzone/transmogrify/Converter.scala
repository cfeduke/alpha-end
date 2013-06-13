package com.deploymentzone.transmogrify

object Converter {

  val Base13 = 13

  def convert(number: Int) : String = {
    def repeatedDivision(accumulator: StringBuilder, dividend: Int): String = {
      // converge
      if (dividend < radix) {
        accumulator.append(table(dividend))
        return accumulator.mkString("").reverse
      }
      // accumulate
      val result = new Division(dividend)
      accumulator.append(table(result.remainder))
      repeatedDivision(accumulator, result.quotient)
    }

    repeatedDivision(new StringBuilder(), number)
  }

  def radix = Base13

  private val lookup = Array[String]("x", "y", "z")
  def table(n: Int) =
    if (n < 10)
      n.toString()
    else if (n > radix)
      throw new ArrayIndexOutOfBoundsException
    else
      lookup.apply(n - 10)

  private class Division(val dividend: Int) {
    val quotient: Int = dividend / radix
    val remainder: Int = dividend % radix
  }
}
