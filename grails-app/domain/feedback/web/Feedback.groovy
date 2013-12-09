package feedback.web

import grails.rest.Resource;

@Resource(uri='/feedbacks')
class Feedback {

	String text
	
	static belongsTo = [owner:Person]
	static hasOne = [category:Category]
	
    static constraints = {
		text blank:false
    }
}
