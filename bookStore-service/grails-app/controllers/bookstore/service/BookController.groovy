package bookstore.service

class BookController {
	BookService bookService

    def index() {
        respond bookService.bookList()
    }
}
