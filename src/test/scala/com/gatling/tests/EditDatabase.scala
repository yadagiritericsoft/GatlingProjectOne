package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class EditDatabase extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_2 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_4 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="102", "Google Chrome";v="102""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")


	val search = exec(http("Home")
			.get("/computers")
			.headers(headers_0))
		.pause(2)
		.exec(http("Search")
			.get("/computers?f=computer")
			.headers(headers_0))
		.pause(3)
		.exec(http("select")
			.get("/computers/300")
			.headers(headers_2))
		.pause(3)

	val edit = exec(http("Edit")
			.post("/computers/300")
			.headers(headers_4)
			.formParam("name", "Atlas Computer")
			.formParam("introduced", "1962-01-07")
			.formParam("discontinued", "1980-01-01")
			.formParam("company", "2"))

	val scn = scenario("EditDatabase").exec(search,edit)
	val users = scenario("Users").exec(search)
	val admins = scenario("Admins").exec(search,edit)

	setUp(
		users.inject(rampUsers(10).during(10)),
		admins.inject(rampUsers(4).during(10))
	).protocols(httpProtocol)

//	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}