package DataMunging
import scala.io.Source


object DataMunging {

    def main(args: Array[String]) ={
    		getMinSpread()
    		getMinGoalDiff()
    }

    def getMinSpread() = {
    	val source = Source.fromFile("weather.dat")
        val min_spread = source.getLines.toList
	                           .drop(2) //the first line is a header and second line is a blank space so skip those lines here.
		                       .map(_.split("\\s+")) // split on regex white space
		                       .map(x => (x(1), x(2).stripSuffix("*").toDouble-x(3).stripSuffix("*").toDouble)) //clean the recourds as somelines have * and aslo conver to double
		                       .reduceLeft((x,y) => if (x._2 < y._2) x else y) // get minimum spread
        println(s"1: the day with the smallest temparature spread is day ${min_spread._1} with a spread of ${min_spread._2} degrees")
        source.close()

    }

    def getMinGoalDiff() = {
    	val source = Source.fromFile("football.dat")
        val team = source.getLines.toList
        				 .drop(1)
        				 .filter(x=> !x.endsWith("-"))
	                     .map(_.split("\\s+"))
	                     .map(x =>(x(2), x(7).toInt - x(9).toInt)) 
	                     .reduceLeft((x,y) => if (x._2 < y._2) x else y) 
        println(s"2: the team with the smallest difference for and against goal is ${team._1} with a difference of ${team._2} degrees")
        source.close()

    }
}