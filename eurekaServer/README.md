#Eureka Server


Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers.

Eureka comes with two components - **Eureka Client** and the **Eureka Server**.

* **Application Client** which uses Eureka Client to make requests to the Application Service.
  
* **Application Service** which receives requests from Application Client and sends a response back.


##Configuring Eureka Server

###Prerequisites:

* JDK 1.8 or higher


To build the Eureka server application, we used  [**SPRING INITIALIZR bootstrap application**](http://start.spring.io/) , generating as a gradle project with Spring boot 1.4.3 and adding **Eureka Server** as a dependency.

In our build.gradle we will have the following dependency:

 `compile('org.springframework.cloud:spring-cloud-starter-eureka-server')`



To Stand up an Eureka Service Registry, we use Sping Cloud’s `@EnableEurekaServer` annotation, This is a regular Spring Boot application with one annotation added to enable the service registry.

**EurekaServerApplication.java**

```
   package com.xala3pa;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
   
   @EnableEurekaServer
   @SpringBootApplication
   public class EurekaServerApplication {
   
   	public static void main(String[] args) {
   		SpringApplication.run(EurekaServerApplication.class, args);
   	}
   }
```

###Configuration

**application.yml**

```
server:  
     port: 8761
   
   eureka:  
     instance:
       hostname: localhost
     client:
       registerWithEureka: false
       fetchRegistry: false
       serviceUrl:
         defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
