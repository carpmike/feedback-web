package feedback.web

import grails.rest.Resource;

@Resource(uri='/categories', formats=['json', 'xml'])
class Category {

	static hasMany = [feedbacks: Feedback]
	
	String name
	
    static constraints = {
		name blank:false
    }
}
