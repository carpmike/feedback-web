package feedback.web

import grails.converters.JSON;
import grails.rest.RestfulController;

class ReminderController extends RestfulController {

	def springSecurityService //injected by spring

    static responseFormats = ['json', 'xml']
    ReminderController() {
        super(Reminder)
    }
	
	// this is really sending an email via POST
	def save(Reminder reminder) {
		def user = springSecurityService.getCurrentUser()

		def p = Person.get(reminder.personId)
		assert p != null
		
		def c = Category.get(reminder.categoryId)
		assert c != null
		
		def fbt = FeedbackType.get(reminder.feedbackTypeId)
		assert fbt != null
		
		def today = new Date().format("M/d/yyyy")
		
		def f = new Feedback(category: c, person: p, feedbackType: fbt, date: today, given: false, text: reminder.text)
		f.save(flush:true, failOnError:true)
		
		String url = "http://www.feedbock.co/#/feedback/$f.id"
		
		String message = "You need to provide $fbt.name feedback on $p.firstName $p.lastName for $c.name. Click the link to do it: " + url 
		
		sendMail {
			to user.email
			subject "Feedback reminder"
			body message
		}
		
		// eventually save the reminder once auth is built in
		
		response.status = 201
		render '{"status":"success"}'
	}
	
    def index() {}
	def show() {}
	def create() {}
	def edit() {}
	def update() {}
	def delete() {}
}
