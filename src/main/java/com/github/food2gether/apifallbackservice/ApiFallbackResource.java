package com.github.food2gether.apifallbackservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.food2gether.shared.response.APIResponse;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.Route.HttpMethod;
import io.quarkus.vertx.web.RoutingExchange;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApiFallbackResource {

  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static final APIResponse API_RESPONSE = APIResponse.apiErrorResponse(404, "Endpoint not found");

  @Route(
      path = "/*",
      methods = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.HEAD, HttpMethod.OPTIONS},
      produces = "application/json"
  )
  public void fallback(RoutingExchange exchange) throws JsonProcessingException {
    exchange.response()
        .setStatusCode(API_RESPONSE.getStatus())
        .end(MAPPER.writeValueAsString(API_RESPONSE));
  }

}
