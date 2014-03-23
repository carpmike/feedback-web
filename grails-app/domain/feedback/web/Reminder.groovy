package feedback.web

import grails.rest.Resource;

@Resource(uri='/reminders', formats=['json', 'xml'])
class Reminder extends UserDomain {

	String personId
	String categoryId
	String feedbackTypeId
		
    static constraints = {
		personId blank:false
		categoryId blank:false
		feedbackTypeId blank:false
    }
}
