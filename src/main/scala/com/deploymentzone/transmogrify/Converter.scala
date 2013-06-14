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
      val (quotient, remainder) = divide(dividend)
      accumulator.append(table(remainder))
      repeatedDivision(accumulator, quotient)
    }

    repeatedDivision(new StringBuilder(), number)
  }

  def radix: Int

  def table(n: Int) = n.toString()

  def divide(dividend: Int) = (dividend / radix, dividend % radix)

}
