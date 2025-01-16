package com.github.food2gether.apifallbackservice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ApiFallbackResourceTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "/",
      "/api/unknown",
      "/some/random/as/endpoint/"
  })
  void testHelloEndpoint(String endpoint) {
    String expected = "{\"success\":false,\"error\":{\"code\":404,\"detail\":\"endpoint.notfound\"}}";
    given()
        .when().get(endpoint)
        .then()
        .statusCode(404)
        .body(is(expected));
  }

}