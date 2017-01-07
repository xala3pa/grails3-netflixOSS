#Hystrix dashboard

Hystrix dashboard to monitor Hystrix metrics in real time.

We can see in the dashboard how a `circuit` is working. When a `circuit` is failing it changes colors on gradient from green to red.

To build the application is as simple as having a Spring boot application with the next dependency to the build path:

`compile "org.springframework.cloud:spring-cloud-starter-hystrix-dashboard"`

and start your application with:

`@EnableHystrixDashboard`

The dashboard can be found at http://localhost:9000/hystrix
