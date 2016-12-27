package catalog.service

class BootStrap {

    def init = { servletContext ->
        new Author(name: "Glen and Peter", surname: "Smith and Ledbrook")
                .addToBooks(new Book(title: "Grails in acton", pages: 576, isbn: 9781617290961))
                .save()
    }
    def destroy = {
    }
}
