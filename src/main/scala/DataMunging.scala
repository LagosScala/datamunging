/**
  * Created by idarlington on 2/26/17.
  */
object DataMunging {

  case class weatherLine(
                          dayNumber : Int,
                          maxTemperature : Double,
                          minTemperature : Double
                        )

  def temperatureDiff (a : weatherLine, b : weatherLine) = {
    (a.maxTemperature - a.minTemperature) > (b.maxTemperature - b.minTemperature)
  }

  def main(args: Array[String]) = {
    /** Read Contents of file **/
    val filename = "weather.dat"
    val fileLines = io.Source.fromFile(filename).getLines().toList

    /** filter empty list contents **/
    val filteredFileLines = fileLines.filter(l => l != "")

    val lines =  filteredFileLines.tail.map(l => l.split(" "))
    val filteredLines = lines.map(l => l.filter(_ != ""))
  }
}
