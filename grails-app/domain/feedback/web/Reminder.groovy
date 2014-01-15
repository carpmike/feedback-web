package feedback.web

import grails.rest.Resource;

@Resource(uri='/reminders', formats=['json', 'xml'])
class Reminder {

	Person person
	Category category
	FeedbackType type
		
    static constraints = {
		person blank:false
		category blank:false
		type blank:false
    }
}
