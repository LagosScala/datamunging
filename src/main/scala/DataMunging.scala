package DataMunging
import scala.io.Source

object DataMunging {

    def main(args: Array[String]) ={
        val source = Source.fromFile("weather.dat")
        val min_spread = source.getLines.toList.drop(2)
                    .map(_.split("\\s+"))
                    .map(x => (x(1), x(2).stripSuffix("*").toDouble,x(3).stripSuffix("*").toDouble))
                    .map(x => (x._1, x._2, x._3, x._2-x._3))
                    .reduceLeft((x,y) => if (x._4 < y._4) x else y)
        println(s"the day with the smallest temparature spread is day ${min_spread._1} with a spread of ${min_spread._4} degrees ")
        source.close()

    }
}