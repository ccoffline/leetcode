object Solution6 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      ("A", 1, "A"),
      ("LEETCODEISHIRING", 3, "LCIRETOESIIGEDHN"),
      ("LEETCODEISHIRING", 4, "LDREOEIIECIHNTSG"),
    )
    for (c <- cases) {
      val result = Solution.convert(c._1, c._2)
      if (result == c._3)
        println(result, c._3)
      else
        System.err.println(result, c._3)
    }
  }

  object Solution {

    def convert(s: String, numRows: Int): String = {
      var b = numRows * 2 - 2
      if (b == 0) return s
      val c = s.toCharArray
      var i, j, a = 0
      while (i < c.length) {
        if (j >= c.length) {
          b -= 2
          a += 2
          j = a / 2
        }
        if (b > 0) {
          c(i) = s(j)
          i += 1
          j += b
        }
        if (j < c.length && a > 0) {
          c(i) = s(j)
          i += 1
          j += a
        }
      }
      String.valueOf(c)
    }
  }
}
