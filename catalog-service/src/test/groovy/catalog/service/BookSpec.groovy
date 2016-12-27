package catalog.service

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends HibernateSpec {

    public static final String TITLE = "Grails in Action"

    void "should has errors when validate domain class constraints"() {
        when: "A domain class is saved with invalid data"
        Book book = new Book(title: "", pages: 576, isbn: 9781617290961)
        book.save()

        then: "There were errors and the data was not saved"
        book.hasErrors()
        book.errors.getFieldError('title')
        Book.count() == 0
    }

    void "should save when validate domain class constraints"() {
        when: "A valid domain is saved"
        Book book = new Book(title: TITLE, pages: 576, isbn: 9781617290961)
        book.save()

        then: "There were errors and the data was not saved"
        Book.count() == 1
        Book.first().title == TITLE
    }
}
