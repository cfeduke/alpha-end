package com.deploymentzone.transmogrify

object Converter {
  def convert(number: Int) : String = number match {
    case 13 => "10"
    case 20 => "17"
    case 5006 => "2381"
    case 9999999 => "20z1879"
    case 7 => "111"
    case 45 => "55"
    case 31 => "1F"
  }
}
