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
		
		String message = "You need to provide $reminder.type feedback on $p.firstName $p.lastName for $c.name" 
		
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
