package com.deploymentzone.transmogrify

object HexConverter extends SymbolicConverter {

  val Base16 = 16

  def radix = Base16

  override def symbols = Array[String]("A", "B", "C", "D", "E", "F")

}
