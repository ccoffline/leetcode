import Solution.twoSum

import scala.collection.mutable

class Solution1 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      (Array(2, 7, 11, 15), 9),
      (Array(-1, -2, -3, -4, -5), -8)
    )
    var c = null
    for (c <- cases) {
      println(twoSum(c._1, c._2).mkString("[", ", ", "]"))
    }
  }
}

object Solution {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val m = new mutable.HashMap[Int, Int]()
    for (i <- nums.indices) {
      val other = target - nums(i)
      if (m.contains(other))
        return Array(i, m(other))
      m.put(nums(i), i)
    }
    null
  }

  //  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  //    var a = 0
  //    var b = nums.length - 1
  //    val m = (
  //      for (i <- a to b) yield (nums(i), i)
  //      ).sorted((a: (Int, Int), b: (Int, Int)) => a._1 - b._1)
  //    var temp = m(a)._1 + m(b)._1
  //    while (temp != target) {
  //      if (temp > target) b -= 1
  //      else a += 1
  //      temp = m(a)._1 + m(b)._1
  //    }
  //    Array(m(a)._2, m(b)._2)
  //  }
}