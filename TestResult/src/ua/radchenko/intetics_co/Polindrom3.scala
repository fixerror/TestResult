package ua.radchenko.intetics_co
import scala.util.control.Breaks._
/**
 * @author FixError
 */
object Polindrom3 extends App {
  var iterator = 0
  val time1 = System.currentTimeMillis();
  rezult(100, 999)

  def isPalindrome(a: Int, b: Int): Boolean = {
    iterator += 1
    var c = a / b
    if (a % b == 0 && c < 999 && c > 100) {
      println(a + " = " + c + " * " + b)
      val time2 = System.currentTimeMillis();
      println(time2 - time1 + "(millis)")
      println("the number of iterations of testing isPalindrome: " + iterator)
      true
      break
    } else {
      false
    }
  }
  def rezult(start: Int, end: Int): Unit = {
    lazy val palindrom = for {
      x <- (start to end).reverse
      b <- (start to end).reverse
      y1 = x.toString.reverse
      c = augmentString(x.toString + y1).toInt
      if isPalindrome(c, b)
    } yield c
    println("length yield:  " + palindrom.length)
  }

}