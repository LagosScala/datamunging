package DataMunging
import scala.io.Source

object DataMunging {

    def main(args: Array[String]) ={
            getMinSpread()
            getMinGoalDiff()
    }
    def getMinSpread() = {
        val source = Source.fromFile("weather.dat")
        val spread = source.getLines.toList
                               .drop(2) //the first line is a header and second line is a blank space so skip those lines here.
                               .map(_.split("\\s+")) // split on regex white space
                               .map(x => (x(1), x(2).stripSuffix("*").toDouble-x(3).stripSuffix("*").toDouble)) //clean the recourds as somelines have * and aslo conver to double
        val min_spread = find_min(spread) // get minimum spread
        println(s"1: the day with the smallest temparature spread is day ${min_spread._1} with a spread of ${min_spread._2} degrees")
        source.close()
    }

    def getMinGoalDiff() = {
        val source = Source.fromFile("football.dat") //get file  access object
        val teams = source.getLines.toList
                         .drop(1) //drop the header
                         .filter(x=> !x.endsWith("-")) // filter out line with ----
                         .map(_.split("\\s+")) // split each line on white space
                         .map(x =>(x(2), x(7).toDouble - x(9).toDouble)) // select team and different between f and a
        val team = find_min(teams)
        println(s"2: the team with the smallest difference for and against goal is ${team._1} with a difference of ${team._2} degrees")
        source.close()
    }
//
//    def getSourceData(filename: String): BufferedSource  = {
//      return Source.fromFile(filename)
//    }

    def find_min(data: List[(String, Double)]): (String, Double)= {
      return data.reduceLeft((x,y) => if (x._2 < y._2) x else y)
    }
}
