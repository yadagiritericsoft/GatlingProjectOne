package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class computerdatabase extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())


	val scn = scenario("computerdatabase")
		.exec(http("ComputersdataBasePage")
			.get("/computers"))
		.pause(2)
		.exec(http("NewComputersPage")
			.get("/computers/new"))
		.pause(2)
		.exec(http("CreateNewComputer")
			.post("/computers")
			.formParam("name", "MyComputer1")
			.formParam("introduced", "2020-01-01")
			.formParam("discontinued", "2021-01-01")
			.formParam("company", "1"))
		.pause(1)
		.exec(http("FilterComputer")
			.get("/computers?f=MyComputer"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}