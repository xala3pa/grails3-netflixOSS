#Catalog Service

A simple service to provide access to the database of books. The idea is to keep the service as simple as possible to focus on the integration between Netflix OSS and Grails 3.

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

