package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks', formats=['json', 'xml'])
class Feedback extends UserDomain {

	Person person 
	String date
	FeedbackType feedbackType
	Category category 
	String text
	Boolean given
	
	static constraints = {
		text nullable: true
		given defaultValue: false
	}
	
	static mapping = {
		person lazy: false
		feedbackType lazy: false
		category lazy: false
	}

    static hibernateFilters = {
        userFilter(condition: ':userId=user_id', types: 'long', default: false)
    }    

}
