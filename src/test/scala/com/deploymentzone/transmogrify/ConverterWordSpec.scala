package com.deploymentzone.transmogrify

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import com.deploymentzone.transmogrify.Converter._

class ConverterWordSpec extends WordSpec with ShouldMatchers {

  "convert when converting decimal to alpha-end encoding" should {

    "return '10' when passed 13." in {
      convert(13) should equal("10")
    }

    "return '17' when passed 20." in {
      convert(20) should equal("17")
    }

    "return '2381' when passed 5006." in {
      convert(5006) should equal("2381")
    }

    "return '20z1879' when passed 9999999." in {
      convert(9999999) should equal("20z1879")
    }
  }

//  "convert when converting decimal to binary encoding" should {
//
//    "return '111' when passed 7." in {
//      convert(7) should equal("111")
//    }
//
//  }
//
//  "convert when converting decimal to octal encoding" should {
//
//    "return '55' when passed 45." in {
//      convert(45) should equal("55")
//    }
//
//  }
//
//  "convert when converting decimal to hex encoding" should {
//
//    "return '1f' when passed 31." in {
//      convert(31) should equal("1F")
//    }
//  }
}
