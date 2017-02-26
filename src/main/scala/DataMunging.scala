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


  }
}
