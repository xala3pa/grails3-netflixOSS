#Config Server

Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. 

With the Config Server you have a central place to manage external properties for applications across all environments. 
The concepts on both client and server map identically to the Spring Environment and PropertySource abstractions, so they fit very well with Spring applications, but can be used with any application running in any language. As an application moves through the deployment pipeline from dev to test and into production you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate. 

The default implementation of the server storage backend uses git so it easily supports labelled versions of configuration environments, as well as being accessible to a wide range of tooling for managing the content. It is easy to add alternative implementations and plug them in with Spring configuration.

To embed in a Spring Boot application we only need to use the @EnableConfigServer annotation:

```
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
```

##Git Backend

The default implementation of EnvironmentRepository uses a Git backend, which is very convenient for managing upgrades and physical environments, and also for auditing changes. 

To change the location of the repository you can set the "spring.cloud.config.server.git.uri" configuration property in the Config Server (e.g. in application.yml)

More info at:	[Spring cloud Server](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html#_spring_cloud_config_server)
