# Spring Boot Microservices
This repository contains the training source code for the Microservice Architecture course:
1. Build Services
2. Service Discovery using Netflix Eureka
2. Implement API Gateway using Spring Cloud Gateway
3. Secure Microservices using Keycloak
4. Implement Circuit Breaker
5. Implement Distributed Tracing
6. Event Driven Architecture using Kafka
7. Dockerize the application
8. Monitoring Microservices using Prometheus and Grafana

## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker

1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.

