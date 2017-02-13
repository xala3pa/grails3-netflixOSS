#Zuul as Reverse Proxy

Spring Cloud has created an embedded Zuul proxy to ease the development of a very common use case where a UI application wants to proxy calls to one or more back end services. 

This feature is useful for a user interface to proxy to the backend services it requires, avoiding the need to manage CORS and authentication concerns independently for all the backends.

Run Zuul is as an easy as adding to a Sprint boot application the following dependency:

`compile('org.springframework.cloud:spring-cloud-starter-zuul')`

To enable it, annotate a Spring Boot main class with `@EnableZuulProxy,` and this forwards local calls to the appropriate service.

Next step is to define routes in the application file:


**Application.yml**  
      
```
zuul:
  routes:
    catalog:
      path: /catalogs/**
      serviceId: catalog-service
``` 
      
This means that http calls to "/catalogs" get forwarded to the "catalog-service" service. 

The route has to have a "path" which can be specified as an ant-style pattern, so "/catalogs/*" only matches one level, but "/catalogs/**" matches hierarchically.


**Nota:** The Zuul starter does not include a discovery client, so for routes based on service IDs you need to provide one of those on the classpath as well (e.g. Eureka is one choice).
