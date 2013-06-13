package com.deploymentzone.transmogrify

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class ConverterWordSpec extends WordSpec with ShouldMatchers with TableDrivenPropertyChecks {

  "convert when converting decimal to alpha-end encoding" should {

    import com.deploymentzone.transmogrify.AlphaEndConverter._

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

    val base13Characters =
      Table(
        ("number", "expected"),
        (0, "0"),
        (1, "1"),
        (2, "2"),
        (3, "3"),
        (4, "4"),
        (5, "5"),
        (6, "6"),
        (7, "7"),
        (8, "8"),
        (9, "9"),
        (10, "x"),
        (11, "y"),
        (12, "z")
      )

    forAll (base13Characters) { (number: Int, expected: String) =>
      f"return ${expected} when passed ${number}" in {
        convert(number) should equal(expected)
      }
    }

    /* todo negatives */
  }

  "convert when converting decimal via identity converter" should {

    import com.deploymentzone.transmogrify.IdentityConverter._

    val base10Characters =
      Table(
        ("number", "expected"),
        (0, "0"),
        (1, "1"),
        (2, "2"),
        (3, "3"),
        (4, "4"),
        (5, "5"),
        (6, "6"),
        (7, "7"),
        (8, "8"),
        (9, "9"),
        (10, "10"),
        (Int.MaxValue, Int.MaxValue.toString())
      )

    forAll (base10Characters) { (number: Int, expected: Any) =>
      f"return ${expected} when passed ${number}" in {
        convert(number) should equal(expected)
      }
    }
  }

  "convert when converting decimal to binary encoding" should {

    import com.deploymentzone.transmogrify.BinaryConverter._

    "return '111' when passed 7." in {
      convert(7) should equal("111")
    }

    /* signed makes it 31 */
    f"return '${"1" * 31}' when passed Int.MaxValue." in {
      convert(Int.MaxValue) should equal("1" * 31)
    }

  }
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
