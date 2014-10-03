package feedback.web

import grails.rest.Resource;

@Resource(uri='/persons', formats=['json', 'xml'], superClass=UndeletableRestfulController)
class Person extends UserDomain {
	
	String firstName
	String lastName
	Boolean isInactive = false
	
    static constraints = {
		firstName blank:false 
		lastName blank:false 
    }

    static hibernateFilters = {
        userFilter(condition: ':userId=user_id', types: 'long', default: false)
    }    

}
