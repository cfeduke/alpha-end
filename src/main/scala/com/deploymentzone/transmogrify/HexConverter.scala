package com.deploymentzone.transmogrify

object HexConverter extends Converter {

  val Base16 = 16

  def radix = Base16

  private val lookup = Array[String]("A", "B", "C", "D", "E", "F")
  override def table(n: Int) = n match {
    case x if 0 until 10 contains x => n.toString()
    case x if 10 until radix contains x => lookup(n - 10)
    case _ => throw new ArrayIndexOutOfBoundsException
  }

}
