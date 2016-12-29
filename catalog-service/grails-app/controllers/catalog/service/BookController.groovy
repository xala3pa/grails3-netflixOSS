package catalog.service

import grails.rest.RestfulController

class BookController extends RestfulController {
    static responseFormats = ['json', 'xml']

    BookController() {
        super(Book)
    }

    def search(String title, Integer max ) {
        if(title) {
            def query = Book.where {
                title ==~ "%${title}%"
            }
            respond query.list(max: Math.min( max ?: 10, 100))
        }
        else {
            respond([])
        }
    }
}
