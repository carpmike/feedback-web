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
	def index(Integer max) {
		int m = Math.min(max ?: 100, 1000)
		log.debug("Feedback index with max: " + m)
		def results = Feedback.withCriteria {
			fetchMode "person", FM.JOIN
			fetchMode "category", FM.JOIN
			fetchMode "feedbackType", FM.JOIN
			maxResults(m)
		}
		results.each {
			// log.debug("Got the feedback for : " + it.person.firstName)
			it.category.name
			it.feedbackType.name
		}
		respond results
	}

}
