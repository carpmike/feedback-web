package feedback.web

import grails.rest.Resource;

@Resource(uri='/categories')
class Category {

	String name
	
    static constraints = {
		name blank:false
    }
}
