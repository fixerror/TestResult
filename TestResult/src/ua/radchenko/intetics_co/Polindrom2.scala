package ua.radchenko.intetics_co

/**
 * @author FixError
 */
object Polindrom extends App {
  var iterator = 0

  def isPalindrome(a: Int): Boolean = {
    iterator += 1
    a.toString == a.toString.reverse
  }
  def rezults(start: Int, end: Int): Int = {
    lazy val palindrom = for {
      x <- (start to end).reverse
      y <- (start to end).reverse
      if isPalindrome(x * y)
    } yield x * y
    println("length yield:  " + palindrom.length)
    palindrom.max
  }
  val time1 = System.currentTimeMillis();
  println("palindrom:  " + rezults(100, 999))
  val time2 = System.currentTimeMillis();
  println(time2 - time1 + "(millis)")
  println("the number of iterations of testing isPalindrome: " + iterator)

}