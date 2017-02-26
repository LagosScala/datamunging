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

    /** filter empty lines **/
    val filteredFileLines = fileLines.filter(l => l != "")

    /** remove header and footer from data  and split lines into Array of Strings **/
    val lines =  filteredFileLines.tail.init.map(l => l.split(" "))

    /** filter out empty indices from array and remove asterisks from data **/
    val filteredLines = lines.map(l => l.filter(_ != "").map(s => s.replaceAll("[*]", "")))

    /** store required data in weatherline instances  **/
    val weatherLines = filteredLines.map(l => weatherLine(l(0).toInt,l(1).toDouble,l(2).toDouble))

  }
}
