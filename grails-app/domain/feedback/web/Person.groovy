package feedback.web

import grails.rest.Resource;

@Resource(uri='/persons', formats=['json', 'xml'])
class Person extends UserDomain {
	
	String firstName
	String lastName
	
    static constraints = {
		firstName blank:false 
		lastName blank:false 
    }
}
