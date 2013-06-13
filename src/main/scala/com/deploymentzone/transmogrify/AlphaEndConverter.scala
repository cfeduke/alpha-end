package com.deploymentzone.transmogrify

object AlphaEndConverter extends Converter {

  val Base13 = 13

  override def radix = Base13

  private val lookup = Array[String]("x", "y", "z")
  override def table(n: Int) =
    if (n < 10)
      n.toString()
    else if (n > radix)
      throw new ArrayIndexOutOfBoundsException
    else
      lookup.apply(n - 10)

}
