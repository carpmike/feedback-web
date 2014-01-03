package feedback.web

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ReminderController)
@Mock([Person, Category])
class ReminderControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "send message via post"() {
		setup:
		def p = new Person(firstName:"Test", lastName:"Test")
		p.save()
		def c = new Category(name: "Test")
		c.save()
		def r = new Reminder(personId: p.id, categoryId: c.id, type: "positive")
		def rc = new ReminderController()
		
		request.method = "POST"
		
		when:
		rc.save(r)
		
		then:
		response.status == 201
		response.text == '{"status":"success"}'
    }
}
