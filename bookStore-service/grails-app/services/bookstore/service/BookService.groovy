package bookstore.service

import grails.converters.JSON
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class BookService {

    def bookList() {
        RestBuilder restBuilder = new RestBuilder()
        def restRep = restBuilder.get("http://localhost:8091/books") {
            accept JSON
        }

        List<Book> users = new ArrayList<>()
        restRep.json.each {
            jSONUser -> users.add(new Book(jSONUser))
        }

        return users

    }
}
