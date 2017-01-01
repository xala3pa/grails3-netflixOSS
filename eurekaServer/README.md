#Eureka Server


Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers.

Eureka comes with two components - **Eureka Client** and the **Eureka Server**.

* **Application Client** which uses Eureka Client to make requests to the Application Service.
  
* **Application Service** which receives requests from Application Client and sends a response back.


##Configuring Eureka Server

###Prerequisites:

* JDK 1.8 or higher


To build the Eureka server appilication, we used  [**SPRING INITIALIZR bootstrap application**](http://http://start.spring.io/) , generating as a gradle project with Spring boot 1.4.3 and adding **Eureka Server** as a dependency


