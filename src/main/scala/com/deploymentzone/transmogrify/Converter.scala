package com.deploymentzone.transmogrify

import scala.annotation.tailrec

trait Converter {
  def convert(number: Int): String = {
    @tailrec
    def repeatedDivision(accumulator: StringBuilder, dividend: Int): String = {
      divide(dividend) match {
        case (quotient, remainder) if quotient > 0 =>
          accumulator.append(table(remainder))
          repeatedDivision(accumulator, quotient)
        case (_, remainder) =>
          accumulator.append(table(dividend)).mkString("").reverse
      }
    }

    repeatedDivision(new StringBuilder(), number)
  }

  def radix: Int

  def table(n: Int) = n.toString()

  def divide(dividend: Int) = (dividend / radix, dividend % radix)

}
