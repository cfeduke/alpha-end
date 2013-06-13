package com.deploymentzone.transmogrify

trait Converter {
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

  def radix: Int

  def table(n: Int) = n.toString()

  private class Division(val dividend: Int) {
    val quotient: Int = dividend / radix
    val remainder: Int = dividend % radix
  }
}
