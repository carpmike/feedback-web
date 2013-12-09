package feedback.web

import grails.rest.Resource;

@Resource(uri='/persons')
class Person {

	String firstName
	String lastName
	
    static constraints = {
		firstName blank:false 
		lastName blank:false 
    }
}
