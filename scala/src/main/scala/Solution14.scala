object Solution14 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      Array("flower", "flow", "flight"),
      Array("dog", "racecar", "car"),
      Array[String]()
    )
    for (c <- cases) {
      println(Solution.longestCommonPrefix(c))
    }
  }

  object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
      if (strs.isEmpty) return ""
      var temp = strs(0)
      for (i <- 1 until strs.length) temp = longestCommonPrefix(temp, strs(i))
      temp
    }

    def longestCommonPrefix(a: String, b: String): String = {
      for (i <- 0 until Math.min(a.length, b.length))
        if (a(i) != b(i))
          return a.substring(0, i)
      if (a.length < b.length) a
      else b
    }
  }

}

