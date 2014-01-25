package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks', formats=['json', 'xml'])
class Feedback {

	Person person 
	String date
	FeedbackType feedbackType
	Category category 
	String text
	
	static constraints = {
		text nullable: true
	}
}
