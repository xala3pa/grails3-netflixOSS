package bookstore.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import grails.converters.JSON
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class BookService {

    @HystrixCommand(fallbackMethod = "getStaticList")
    def bookList() {
        RestBuilder restBuilder = new RestBuilder()
        def restRep = restBuilder.get("http://localhost:8084/catalog-service/books") {
            accept JSON
        }

        List<Book> users = new ArrayList<>()
        restRep.json.each {
            jSONUser -> users.add(new Book(jSONUser))
        }

        return users
    }

    def getStaticList() {
        List<Book> books = new ArrayList<>()
        books.add(new Book(title: "Code Complete", pages: 960, isbn: "978-0735619678"))
        books.add(new Book(title: "The Mythical Man-Month", pages: 336, isbn: "978-0201835953"))
        books.add(new Book(title: "The Pragmatic Programmer", pages: 352, isbn: "978-0201616224"))

        return books
    }
}
