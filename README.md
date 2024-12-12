# api-fallback-service
[![Quality Gate
Status](https://sonarcloud.io/api/project_badges/measure?project=food2gether_api-fallback-service&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=food2gether_api-fallback-service)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=food2gether_api-fallback-service&metric=coverage)](https://sonarcloud.io/summary/new_code?id=food2gether_api-fallback-service)
[![GitHub Actions](https://github.com/food2gether/api-fallback-service/actions/workflows/protected-push.yaml/badge.svg)](https://github.com/food2gether/api-fallback-service/actions/workflows/protected-push.yaml)
![GitHub Release](https://img.shields.io/github/v/release/food2gether/api-fallback-service)

This project is a simple quarkus rest serivce responding to any request with a simple 404 response
and a json body.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

## Package the application for production
```shell script
./mvnw package -Pnative
```

## Build the docer image
NOTE: You need to build the application first with maven
```shell script
docker build -f src/main/docker/Dockerfile.native-micro -t quarkus/api-fallback-service .
```

## Run the docker image
```shell script
docker run -i --rm -p 8080:8080 ghcr.io/food2gether/api-fallback-service:<version>
```