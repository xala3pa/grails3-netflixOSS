package catalog.service

class Book {
    String title
    Integer pages
    String isbn

    static belongsTo = Author
    static hasMany = [authors: Author]

    static constraints = {
        title blank: false
        isbn blank: false
    }
}
