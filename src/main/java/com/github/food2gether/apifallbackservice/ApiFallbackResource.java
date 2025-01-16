package com.github.food2gether.apifallbackservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.food2gether.response.ErrorResponse;
import com.github.food2gether.response.Response;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.Route.HttpMethod;
import io.quarkus.vertx.web.RoutingExchange;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApiFallbackResource {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Route(
      path = "/*",
      methods = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.HEAD, HttpMethod.OPTIONS},
      produces = "application/json"
  )
  public void fallback(RoutingExchange exchange) throws JsonProcessingException {
    ErrorResponse response = Response.of(404, "endpoint.notfound");
    exchange.response()
        .setStatusCode(response.getError().getCode())
        .end(MAPPER.writeValueAsString(response));
  }

}
