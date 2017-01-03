#Catalog Service

A simple service to provide access to the database of books. 
The idea is to keep the service as simple as possible to focus on the integration between Netflix OSS and Grails 3.

The service is base on Grails 3 rest-api profile, designed for the creation of pure REST applications without a UI.

This the list of the endpoints:

**Books List**
----
  Returns json array about a books.

* **URL**

  /books

* **Method:**

  `GET`
  
*  **URL Params**

   None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"id":1,"authors":[{"id":1}],"isbn":"9781617290961","pages":576,"title":"Grails in acton"}]`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{"message":"Not Found","error":404}`
    
* **Sample Call:**
   
  ```
  curl -i  localhost:8080/books
  ```



**Show Book**
----
  Returns json data about a single book.

* **URL**

  /book/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"id":1,"authors":[{"id":1}],"isbn":"9781617290961","pages":576,"title":"Grails in action"}`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{"message":"Not Found","error":404}`

* **Sample Call:**

  ```
  curl -i  localhost:8080/book/1
  ```

**Add Book**
----
  Add new data about a single book.

* **URL**

  /books

* **Method:**

  `POST`
  
*  **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 201 <br />
    **Content:** `{"id":2,"isbn":"1449358063","pages":406,"title":"RESTful Web APIs"}`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{"message":"Not Found","error":404}`

* **Sample Call:**

  ```
  curl -i -H "Content-Type:application/json" -X POST localhost:8080/books -d '{"title":"RESTful Web APIs","pages":406, "isbn":"1449358063"}'
  ```

**Delete Book**
----
  Remove data about a single book.

* **URL**

  /books/:id

* **Method:**

  `DELETE`
  
*  **URL Params**

  **Required:**
   
     `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 204 <br />
      **Content:** None
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{"message":"Not Found","error":404}`

* **Sample Call:**

  ```
  curl -i -X DELETE localhost:8080/books/2
  ```
  
**Update Book**
----
    Update data about a single book.
  
* **URL**
  
  /books/:id
  
* **Method:**
  
  `PUT`
    
*  **URL Params**
  
  **Required:**
     
     `id=[integer]`
  
* **Data Params**
  
  None
  
* **Success Response:**
  
  * **Code:** 200 <br />
      **Content:** `{"id":3,"authors":[],"isbn":"1449358063","pages":406,"title":"RESTful Web API v2"}`  
  * **Error Response:**
  
  * **Code:** 404 NOT FOUND <br />
      **Content:** `{"message":"Not Found","error":404}`
  
  * **Code:** 422 UNPROCESSABLE ENTITY  <br />
    **Content:** `{"message":"Property [isbn] of class [class catalog.service.Book] cannot be null","path":"","_links":{"self":{"href":"http://localhost:8080"}}}`
  
* **Sample Call:**
  
  ```
  curl -i -H "Content-Type:application/json" -X PUT localhost:8080/books/3 -d '{"title":"RESTful Web API v2"}'
  ```

  
---
Some steps to build our REST service:
  
Prerequisites:
  
  * JDK 1.7 or greater installed.
  * Grails 3 or greater.
  * Gradle
  
I'm using the amazing SDKMAN!! more info in [SDKMAN website](http://sdkman.io/).
  
To create the application once installed Grails, only executes:

`$ grails create-app catalog-service --profile rest-api`

Then create some Domain objects and a controller extending from the `RestfulController` super class will implement all the necessary operations to perform the common REST verbs such as GET, POST, PUT and DELETE.

Next, to include our application as a Eureka client we need to add a new dependency to our `build.gradle` file: 

`compile "org.springframework.cloud:spring-cloud-starter-eureka"`

To solve version mismatch issue, we can add a “bill of materials” (BOM) dependency, to do that we only need to add Spring cloud dependency management:
 
`mavenBom 'org.springframework.cloud:spring-cloud-dependencies:Camden.RELEASE'` 


Annotate our main class with `@EnableEurekaClient`:

```
package catalog.service
   
   import grails.boot.GrailsApp
   import grails.boot.config.GrailsAutoConfiguration
   import org.springframework.cloud.netflix.eureka.EnableEurekaClient
   
   @EnableEurekaClient
   class Application extends GrailsAutoConfiguration {
       static void main(String[] args) {
           GrailsApp.run(Application, args)
       }
   }
```

and finally configure the service, adding the following to our `application.yml` file:

```
eureka:
     client:
       registryFetchIntervalSeconds: 5
       serviceUrl:
         defaultZone: http://eureka:admin@127.0.0.1:8761/eureka/
     instance:
       preferIpAddress: true
       leaseRenewalIntervalInSeconds: 10
       metadataMap:
         instanceId: ${spring.application.name}:${spring.application.instance_id}:${random.int}
```