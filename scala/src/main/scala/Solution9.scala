object Solution9 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      121,
      -121,
      10,
    )
    for (c <- cases) {
      println(Solution.isPalindrome(c))
    }
  }

  object Solution {
    def isPalindrome(x: Int): Boolean = {
      if (x < 0) return false
      reverse(x) == x
    }

    def reverse(x: Int): Int = {
      var ans = 0;
      var o = x;
      while (o != 0) {
        val t = o % 10
        if (Int.MaxValue / 10 < ans) return 0
        ans *= 10
        if (Int.MaxValue - ans < t) return 0
        ans += t
        o /= 10
      }
      ans
    }
  }

}
