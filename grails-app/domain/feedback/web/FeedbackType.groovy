package feedback.web;

import grails.rest.Resource;

@Resource(uri='/feedbackTypes', formats=['json', 'xml'])
public class FeedbackType {
	
	String name
	
	static constraints = {
		name inList: ["positive", "constructive"]
	}
}
