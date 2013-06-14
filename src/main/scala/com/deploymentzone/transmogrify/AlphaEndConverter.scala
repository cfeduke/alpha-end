package com.deploymentzone.transmogrify

object AlphaEndConverter extends Converter {

  val Base13 = 13

  override def radix = Base13

  private val lookup = Array[String]("x", "y", "z")
  override def table(n: Int) = n match {
    case x if 0 until 10 contains x => n.toString()
    case x if 10 until radix contains x => lookup(n - 10)
    case _ => throw new ArrayIndexOutOfBoundsException
  }

}
