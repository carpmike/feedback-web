import feedback.web.*
import grails.converters.JSON;


class BootStrap {

    def init = { servletContext ->
		// create the roles
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        // create the admin user
		def adminUser = new User(username: 'admin', enabled: true, password: 'f33db0ck_admin')
		adminUser.save(flush: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole, true
        }

        // create my user
		def mikeUser = new User(username: 'mike', enabled: true, password: 'f33db0ck_mike')
		mikeUser.save(flush: true)

        if (!mikeUser.authorities.contains(adminRole)) {
            UserRole.create mikeUser, userRole, true
        }

		assert User.count() == 2
		assert Role.count() == 2
		assert UserRole.count() == 2	
    	
    	environments {
    		development {
				def p1 = new Person(firstName:"Sug", lastName:"Arun", userId: mikeUser.id).save()
				new Person(firstName:"B", lastName:"North", userId: mikeUser.id).save()
				new Person(firstName:"Abs", lastName:"Hash", userId: mikeUser.id).save()
				new Person(firstName:"Flavin", lastName:"Flav", userId: mikeUser.id).save()
				new Person(firstName:"Deano", lastName:"Vooch", userId: mikeUser.id).save()
				new Person(firstName:"Kristop", lastName:"Vool", userId: mikeUser.id).save()
				new Person(firstName:"Quotes", lastName:"Stien", userId: mikeUser.id).save()
				new Person(firstName:"J", lastName:"G", userId: mikeUser.id).save()
				new Person(firstName:"Mr", lastName:"Commish", userId: mikeUser.id).save()
				
				def c1 = new Category(name:"Presentation", userId: mikeUser.id).save()
				new Category(name:"Communication", userId: mikeUser.id).save()
				new Category(name:"Work Product", userId: mikeUser.id).save()
				new Category(name:"Helping", userId: mikeUser.id).save()
				new Category(name:"Coaching", userId: mikeUser.id).save()
				new Category(name:"Listening", userId: mikeUser.id).save()
				
		//		log.debug "About to save the feedback!@!"
				def fbt = new FeedbackType(name:"positive").save()
				new FeedbackType(name:"constructive").save(flush:true)
				
				def f1 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 1", date: "01/22/2014", userId: mikeUser.id)
				def f2 = new Feedback(person: p1, category: c1, feedbackType: fbt, text: "Bootstrap 2", date: "02/22/2014", userId: mikeUser.id)
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
		}
	}
}
