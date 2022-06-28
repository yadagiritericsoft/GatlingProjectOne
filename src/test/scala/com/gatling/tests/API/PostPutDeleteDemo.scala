package com.gatling.tests.API

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PostPutDeleteDemo extends Simulation{
  //protocol
  val httpProtocol = http
    .baseUrl("https://reqres.in/api")

  //Scenario
  val createUserScn = scenario("Create User")
    .exec(
      http("Create User Request")
        .post("/users")
        .header("content-type","application/json")
        .asJson
        .body(RawFileBody("data/user.json")).asJson
//        .body(StringBody(
//          """
//            |{
//            |    "name": "John",
//            |    "job": "leader"
//            |}
//            |""".stripMargin)).asJson
        .check(
          status is 201,
          jsonPath("$.name") is "morpheus"
        )
    )
    .pause(1)

  val updateUserScn = scenario("Update User")
    .exec(
      http("update user")
        .put("/users/2")
        .body(RawFileBody("data/user.json")).asJson
        .check(
         status is 200,
         jsonPath("$.name") is "morpheus"
       )

    )
    .pause(1)

  //Setup
  setUp(
    createUserScn.inject(rampUsers(10).during(5)) ,
    updateUserScn.inject(rampUsers(5).during(3))
  ).protocols(httpProtocol)
}
