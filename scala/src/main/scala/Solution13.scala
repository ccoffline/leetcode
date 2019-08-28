object Solution13 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      "III",
      "IV",
      "IX",
      "LVIII",
      "MCMXCIV"
    )
    for (c <- cases) {
      println(Solution.romanToInt(c))
    }
  }

  object Solution {
    private val m = Map(
      ("I", 1),
      ("IV", 3),
      ("V", 5),
      ("IX", 8),
      ("X", 10),
      ("XL", 30),
      ("L", 50),
      ("XC", 80),
      ("C", 100),
      ("CD", 300),
      ("D", 500),
      ("CM", 800),
      ("M", 1000)
    )

    def romanToInt(s: String): Int = {
      var ans = m(s.substring(0, 1))
      for (i <- 2 to s.length) {
        val two = m.get(s.substring(i - 2, i))
        if (two.isDefined) ans += two.get
        else ans += m(s.substring(i - 1, i))
      }
      ans
    }
  }

}
