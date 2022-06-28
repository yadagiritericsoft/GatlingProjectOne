package com.gatling.tests.API

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class APITestOne extends  Simulation{

  //protocol
  val httpProtocol = http
    .baseUrl("https://reqres.in/api/users")

  //scenario
  val scn = scenario("Get API Request Demo  ")
    .exec(
      http("Get Single User")
        .get("/2")
        .check(
          status.is(200),
          jsonPath("$.data.first_name").is("Janet")
        )
    )
    .pause(2)

  //setup
  setUp(
    scn.inject(atOnceUsers(10))
      .protocols(httpProtocol)
  )

}
