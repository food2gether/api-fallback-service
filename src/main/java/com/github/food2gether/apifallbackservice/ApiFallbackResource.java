package com.github.food2gether.apifallbackservice;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApiFallbackResource {

  private static final String NOT_FOUND_RESPONSE = """
        {
          "success": false,
          "error": {
            "code": 404,
            "message": "endpoint.notfound"
          }
        }
        """.replaceAll("[\\n ]", "");

  @Route(path = "/*")
  public void fallback(RoutingExchange exchange) {
    exchange.notFound().end(NOT_FOUND_RESPONSE);
  }

}
