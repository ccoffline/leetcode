object Solution7 {
  def main(args: Array[String]) {
    val cases = Array(
      1534236469,
      -2147483648,
      123,
      -123,
      120,
    )
    for (c <- cases) {
      println(Solution.reverse(c))
    }
  }

  object Solution {
    def reverse(x: Int): Int = {
      if (x == Int.MinValue) return 0
      if (x < 0) return -reverse(-x)
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
