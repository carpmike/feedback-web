package feedback.web

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ReminderController)
@Mock([Person, Category, FeedbackType])
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
		def fbt = new FeedbackType(name: "positive")
		fbt.save()
		
		def r = new Reminder(personId: p.id, categoryId: c.id, feedbackTypeId: 1)
		def rc = new ReminderController()
		
		request.method = "POST"
		
		when:
		rc.save(r)
		
		then:
		response.status == 201
		response.text == '{"status":"success"}'
    }
}
