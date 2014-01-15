package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks', formats=['json', 'xml'])
class Feedback {

	Person person 
	Date date
	FeedbackType feedbackType
	Category category 
	String text
		
    static constraints = {
		person blank:false
		date blank:false
		feedbackType blank:false
		category blank:false
		text blank:false		
    }
}
