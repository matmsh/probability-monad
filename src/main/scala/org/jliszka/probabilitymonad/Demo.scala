package org.jliszka.probabilitymonad
import Distribution._

object Demo {

  def main(args: Array[String]): Unit = {
    dieDemo2()
  }

  // Two dices
  def dieDemo2(): Unit = {
    val twoDices = for {
      numA <- die
      numB <- die
    } yield numA + numB

    println(twoDices.sample(10))
    // Gives wrong answer when samples is 100000 or larger !
    val probOfFactorOf5 = twoDices.pr(pred = _ % 5 == 0, samples = 100000)
    val expected        = 7.0 / 36.0
    println(f"probOfFactor of 5=$probOfFactorOf5%.4f, expected=$expected%.4f")

  }

}
