package catalog.service

class Book {
    String title
    long pages
    String isbn

    static belongsTo = Author
    static hasMany = [authors: Author]

    static constraints = {
        title blank: false
        pages size: 1..1000, blank: false
        isbn blank: false
    }
}
