package DataMunging
import scala.io.Source

object DataMunging {

    def main(args: Array[String]) ={
        val source = Source.fromFile("weather.dat")
        val min_spread = source.getLines.toList
                         .drop(2) //the first line is a header and second line is a blank space so skip those lines here.
	                 .map(_.split("\\s+")) // split on regex white space
	                 .map(x => (x(1), x(2).stripSuffix("*").toDouble,x(3).stripSuffix("*").toDouble)) //clean the recourds as somelines have * and aslo conver to double
	                 .map(x => (x._1, x._2, x._3, x._2-x._3)) //calculate the spread
	                 .reduceLeft((x,y) => if (x._4 < y._4) x else y) // get minimum spread
        println(s"the day with the smallest temparature spread is day ${min_spread._1} with a spread of ${min_spread._4} degrees ")
        source.close()

    }
}
