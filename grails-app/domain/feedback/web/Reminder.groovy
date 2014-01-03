package feedback.web

import grails.rest.Resource;

@Resource(uri='/reminders', formats=['json', 'xml'])
class Reminder {

	Integer personId
	Integer categoryId
	String type
	
    static constraints = {
		personId blank:false
		categoryId blank:false
		type blank:false
    }
}
