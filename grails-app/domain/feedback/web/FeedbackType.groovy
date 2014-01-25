package feedback.web;

public class FeedbackType {
	
	String name
	
	static constraints = {
		name inList: ["positive", "negative"]
	}
}
