package feedback.web

import grails.converters.JSON
import org.hibernate.FetchMode as FM

import grails.rest.RestfulController

class FeedbackController extends RestfulController<Feedback> {

    static responseFormats = ['json', 'xml']
	
    FeedbackController() {
        super(Feedback)
    }
	
    // override to get the associations
	def index() {
		log.debug("Feedback index")
		def results = Feedback.withCriteria {
			fetchMode "person", FM.JOIN
			fetchMode "category", FM.JOIN
			fetchMode "feedbackType", FM.JOIN
		}
		results.each {
			log.debug("Got the feedback for : " + it.person.firstName)
			it.category.name
			it.feedbackType.name
		}
		respond results
	}

}
