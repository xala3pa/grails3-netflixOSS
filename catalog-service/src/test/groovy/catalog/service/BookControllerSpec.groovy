package catalog.service

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor

@TestFor(BookController)
class BookControllerSpec extends HibernateSpec {

    //enable JSON viewa
    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void setup() {
        Book.saveAll(
                new Book(title: "title1", pages: 100, isbn: "1123123"),
                new Book(title: "title2", pages: 100, isbn: "34534543"),
                new Book(title: "title3", pages: 100, isbn: "89798787")
        )
    }

    void "test the search action finds results"() {
        when: "A query is executed that finds results"
        controller.search('title', 10)

        then: "The response is correct"
        response.json.size() == 3
    }
}