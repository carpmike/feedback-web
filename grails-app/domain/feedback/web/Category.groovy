package feedback.web

import grails.rest.Resource;

@Resource(uri='/categories')
class Category {

	static hasMany = [feedbacks: Feedback]
	
	String name
	
    static constraints = {
		name blank:false
    }
}
