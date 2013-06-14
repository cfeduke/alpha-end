package com.deploymentzone.transmogrify

trait SymbolicConverter extends Converter {

  def symbols: Array[String]

  override def table(n: Int) = n match {
    case x if 0 until 10 contains x => n.toString()
    case x if 10 until symbols.length + 10 contains x => symbols(n - 10)
    case _ => throw new ArrayIndexOutOfBoundsException
  }

}
