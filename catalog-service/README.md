#Catalog Service

A simple service to provide access to the database of books. 
The idea is to keep the service as simple as possible to focus on the integration between Netflix OSS and Grails 3.

The service is base on Grails 3 rest-api profile, designed for the creation of pure REST applications without a UI.



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

**Add a Book**
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
