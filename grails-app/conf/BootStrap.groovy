import feedback.web.*

class BootStrap {

    def init = { servletContext ->
		def p1 = new Person(firstName:"Sug", lastName:"Arun").save()
		new Person(firstName:"B", lastName:"North").save()
		new Person(firstName:"Abs", lastName:"Hash").save()
		new Person(firstName:"Flavin", lastName:"Flav").save()
		new Person(firstName:"Deano", lastName:"Vooch").save()
		new Person(firstName:"Kristop", lastName:"Vool").save()
		new Person(firstName:"Quotes", lastName:"Stien").save()
		new Person(firstName:"J", lastName:"G").save()
		new Person(firstName:"Mr", lastName:"Commish").save()
		
		def c1 = new Category(name:"Presentation").save()
		new Category(name:"Communication").save()
		new Category(name:"Work Product").save()
		new Category(name:"Helping").save()
		new Category(name:"Coaching").save()
		new Category(name:"Listening").save()
		
//		log.debug "About to save the feedback!@!"
		def fbt = new FeedbackType(name:"positive").save()
		new FeedbackType(name:"constructive").save(flush:true)
		
		def f1 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 1", feedbackDate: "01/22/2014")
		f1.save(flush: true)
    }
    def destroy = {
		Person.findAll().each {
			it.delete()
		}
    }
}
