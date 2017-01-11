# Grails 3 + Netflix OSS
Lab project to integrate Spring Cloud Netflix  into a Grails 3 micro services application.

Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot we will try to integrate this functionalities into a Grails 3 application.

The patterns provided include Service Discovery (Eureka), Circuit Breaker (Hystrix), Intelligent Routing (Zuul) and Client Side Load Balancing (Ribbon)...

###Features from Spring Cloud Netflix, we want to try:

**Service Discovery**: Eureka instances can be registered and clients can discover the instances using Spring-managed beans.

**Circuit Breaker**: Hystrix clients can be built with a simple annotation-driven method decorator

**External Configuration**: a bridge from the Spring Environment to Archaius (enables native configuration of Netflix components using Spring Boot conventions).

**Router and Filter**: automatic regsitration of Zuul filters, and a simple convention over configuration approach to reverse proxy creation.
