A new magical number system called "alpha-end" has been designed. This number system is similar to hexadecimal but has
the following characters: `0 1 2 3 4 5 6 7 8 9 x y z`
(basically the decimal number system plus the 3 characters x, y and z)

Therefore converting from decimal to alpha-end gives the following:

    5 => 5
    10 => x
    13 => 10
    20 => 17

Your task is to implement the Converter.Convert method for this new number system to get all the
unit tests passing. Feel free to add more unit tests as you work if it helps you test drive to the goal.
You will be judged based on accuracy and the architecture you design to implement the solution.

Once you have completed the implementation of the alpha-end converter refactor the code to support the additional
encodings.

Your solution will only be accepted through github (public or private repository).

Use git to manage your progress.  We will check your commits to assess how you work through a problem.

The following is written in Scala and we prefer it to implemented in Scala.  However, we will also accept
implementations written in the following languages (in order of preference).

* Java
* Ruby
* C#
* Javascript
* C++
* C

The tests:

```scala
class EncodingUnitSpec extends WordSpec with ShouldMatchers {

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

  "convert when converting decimal to binary encoding" should {

    "return '111' when passed 7." in {
      convert(7) should equal("111")
    }

  }

  "convert when converting decimal to octal encoding" should {

    "return '55' when passed 45." in {
      convert(45) should equal("55")
    }

  }

  "convert when converting decimal to hex encoding" should {

    "return '1f' when passed 31." in {
      convert(31) should equal("1F")
    }
  }
}
```
