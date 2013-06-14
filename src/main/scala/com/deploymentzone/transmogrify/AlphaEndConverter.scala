package com.deploymentzone.transmogrify

object AlphaEndConverter extends SymbolicConverter {

  val Base13 = 13

  override def radix = Base13

  override def symbols = Array[String]("x", "y", "z")

}
