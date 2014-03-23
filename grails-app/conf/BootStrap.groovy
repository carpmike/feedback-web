import feedback.web.*
import grails.converters.JSON;


class BootStrap {

    def init = { servletContext ->
		// security setup
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

		def adminUser = new User(username: 'admin', enabled: true, password: 'admin')
		adminUser.save(flush: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole, true
        }

		assert User.count() == 1
		assert Role.count() == 2
		assert UserRole.count() == 1		

		def p1 = new Person(firstName:"Sug", lastName:"Arun", userId: adminUser.id).save()
		new Person(firstName:"B", lastName:"North", userId: adminUser.id).save()
		new Person(firstName:"Abs", lastName:"Hash", userId: adminUser.id).save()
		new Person(firstName:"Flavin", lastName:"Flav", userId: adminUser.id).save()
		new Person(firstName:"Deano", lastName:"Vooch", userId: adminUser.id).save()
		new Person(firstName:"Kristop", lastName:"Vool", userId: adminUser.id).save()
		new Person(firstName:"Quotes", lastName:"Stien", userId: adminUser.id).save()
		new Person(firstName:"J", lastName:"G", userId: adminUser.id).save()
		new Person(firstName:"Mr", lastName:"Commish", userId: adminUser.id).save()
		
		def c1 = new Category(name:"Presentation", userId: adminUser.id).save()
		new Category(name:"Communication", userId: adminUser.id).save()
		new Category(name:"Work Product", userId: adminUser.id).save()
		new Category(name:"Helping", userId: adminUser.id).save()
		new Category(name:"Coaching", userId: adminUser.id).save()
		new Category(name:"Listening", userId: adminUser.id).save()
		
//		log.debug "About to save the feedback!@!"
		def fbt = new FeedbackType(name:"positive").save()
		new FeedbackType(name:"constructive").save(flush:true)
		
		def f1 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 1", date: "01/22/2014", userId: adminUser.id)
		def f2 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 2", date: "02/22/2014", userId: adminUser.id)
		f1.save(flush: true)
		f2.save(flush:true)
		
		[c1, fbt, f1, f2].each {
			if (it.errors.allErrors.size() > 0) System.out.println("!!!! errors: " + it.errors)
		}

		// JSON mappings to get the output the way we want it *and* pre-fetch all the associations
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
    }
}
