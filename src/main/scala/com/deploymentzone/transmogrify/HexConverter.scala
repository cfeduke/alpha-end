package com.deploymentzone.transmogrify

object HexConverter extends Converter {

  val Base16 = 16

  def radix = Base16

  private val lookup = Array[String]("A", "B", "C", "D", "E", "F")
  override def table(n: Int) =
    if (n < 10)
      n.toString()
    else if (n > radix)
      throw new ArrayIndexOutOfBoundsException
    else
      lookup.apply(n - 10)
}
