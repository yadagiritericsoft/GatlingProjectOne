package test.scala.com.gatling.tests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class feederdemo extends Simulation {

  //protocol
  val httpProtocol = http.baseUrl("https://computer-database.gatling.io/");


  //scenario
  val feeder = csv("data/data1.csv").circular

  val scn = scenario("Feeders demo")
    .repeat(3) {
      feed(feeder)
       .exec { session =>
        println("Name:  " + session("name").as[String])
        println("job:  " + session("job").as[String])
        println("page:  " + session("page").as[String])
         session
       }
        .pause(1)
        .exec(http("Goto Home Page").get("/#{page}"))
    }
  //setup
  setUp(scn.inject(atOnceUsers(3))).protocols(httpProtocol)

}
