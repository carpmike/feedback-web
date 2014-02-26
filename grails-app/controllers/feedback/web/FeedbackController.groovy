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
		System.out.println("Feedback index")
		def results = Feedback.withCriteria {
			fetchMode "person", FM.JOIN
			fetchMode "category", FM.JOIN
			fetchMode "feedbackType", FM.JOIN
		}
		results.each {
			System.out.println it.person.firstName
			it.category.name
			it.feedbackType.name
		}
		respond results
	}
	
	def show() {
		System.out.println("Feedback show")
		respond Feedback.findAll([fetch:[person:"eager"]])
	}

}
