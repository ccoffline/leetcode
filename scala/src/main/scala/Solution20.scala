object Solution20 {
  def main(args: Array[String]): Unit = {
    val cases = Array(
      "{[]}",
      "",
      "()",
      "(){}[",
      "]",
    )
    for (c <- cases) {
      println(Solution.isValid(c))
    }
  }

  object Solution {

    import scala.collection.mutable.ListBuffer
    private val map = Map((')', '('), (']', '['), ('}', '{'))

    def isValid(s: String): Boolean = {
      val stack = ListBuffer[Char]()
      for (c <- s) {
        if (!map.contains(c)) stack.insert(0, c)
        else if (stack.nonEmpty && stack.head == map(c)) stack.remove(0)
        else return false
      }
      stack.isEmpty
    }
  }

}
