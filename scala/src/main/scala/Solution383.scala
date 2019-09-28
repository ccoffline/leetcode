object Solution383 {
  def main(args: Array[String]): Unit = {

  }
}

object Solution {

  import scala.collection.mutable

  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val map = mutable.HashMap[Char, Int]()
    for (c <- ransomNote)
      map(c) = map.getOrElse(c, 0) + 1
    var count = ransomNote.length
    for (c <- magazine) {

    }
  }
}