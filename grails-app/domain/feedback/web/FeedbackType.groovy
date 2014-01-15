package feedback.web;

public enum FeedbackType {
	POSITIVE("Positive"),
	CONSTRUCTIVE("Constructive")
	
	final String value
	
	FeedbackType(String value) {
		this.value = value;
	}
	
	String toString() {value}
	String getKey() {name()}
}
