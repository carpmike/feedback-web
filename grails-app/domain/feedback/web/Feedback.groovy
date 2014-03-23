package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks', formats=['json', 'xml'])
class Feedback extends UserDomain {

	Person person 
	String date
	FeedbackType feedbackType
	Category category 
	String text
	
	static constraints = {
		text nullable: true
	}
	
	static mapping = {
		person lazy: false
		feedbackType lazy: false
		category lazy: false
	}
}
