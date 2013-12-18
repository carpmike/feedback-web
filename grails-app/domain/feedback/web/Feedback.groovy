package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks')
class Feedback {

	String text
	Category category 
	Person person 
		
    static constraints = {
		text blank:false
    }
}
