import feedback.web.*
import grails.converters.JSON;


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
		
		def f1 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 1", date: "01/22/2014")
		def f2 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 2", date: "02/22/2014")
		f1.save(flush: true)
		f2.save(flush:true)
		
		[c1, fbt, f1, f2].each {
			if (it.errors.allErrors.size() > 0) System.out.println("!!!! errors: " + it.errors)
		}
		
		JSON.registerObjectMarshaller(Feedback) { 
			def fb = [:]
			fb['text'] = it.text
			fb['date'] = it.date
			fb['id'] = it.id
			def p = [:]
			p['firstName'] = it.person.firstName
			p['lastName'] = it.person.lastName
			p['id'] = it.person.id
			fb['person'] = p
			def c = [:]
			c['name'] = it.category.name
			c['id'] = it.person.id
			fb['category'] = c
			def ft = [:]
			ft['name'] = it.feedbackType.name
			ft['id'] = it.feedbackType.id
			fb['feedbackType'] = ft

			return fb
		}
    }
    def destroy = {
		Person.findAll().each {
			it.delete()
		}
    }
}
