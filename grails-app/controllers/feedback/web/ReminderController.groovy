package feedback.web

import grails.converters.JSON;
import grails.rest.RestfulController;

class ReminderController extends RestfulController {

    static responseFormats = ['json', 'xml']
    ReminderController() {
        super(Reminder)
    }
	
	// this is really sending an email via POST
	def save(Reminder reminder) {
		def p = Person.get(reminder.personId)
		assert p != null
		
		def c = Category.get(reminder.categoryId)
		assert c != null
		
		def fbt = FeedbackType.get(reminder.feedbackTypeId)
		assert fbt != null
		
		def today = new Date().format("MM/dd/yyyy")
		
		def f = new Feedback(category: c, person: p, feedbackType: fbt, date: today)
		f.save(flush:true, failOnError:true)
		
		String url = "http://localhost:9191/#/feedback/$f.id"
		
		String message = "You need to provide $fbt.name feedback on $p.firstName $p.lastName for $c.name. Click the link to do it: " + url 
		
		sendMail {
			to "carpmike@gmail.com"
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
