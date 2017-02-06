package bookstore.service

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker

@EnableCircuitBreaker
class BookController {
	BookService bookService

    def index() {
        respond bookService.bookList()
    }
}
