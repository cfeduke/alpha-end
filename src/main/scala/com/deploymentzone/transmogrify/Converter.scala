package com.deploymentzone.transmogrify

object Converter {

  val Base13 = 13

  def convert(number: Int) : String = {
    def repeatedDivision(accumulator: StringBuilder, dividend: Int): String = {
      // converge
      if (dividend < getRadix) {
        accumulator.append(dividend)
        return accumulator.mkString("").reverse
      }
      // accumulate
      val result = new Division(dividend)
      accumulator.append(result.remainder)
      repeatedDivision(accumulator, result.quotient)
    }

    repeatedDivision(new StringBuilder(), number)
  }

  def getRadix = Base13

  private class Division(val dividend: Int) {
    val quotient: Int = dividend / getRadix
    val remainder: Int = dividend % getRadix
  }
}
