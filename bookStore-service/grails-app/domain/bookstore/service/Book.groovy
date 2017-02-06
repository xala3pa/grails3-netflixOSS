package bookstore.service

class Book {
    String title
    Integer pages
    String isbn

    static constraints = {
        title blank: false
        isbn blank: false
    }
}
