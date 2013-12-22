import feedback.web.Person

class BootStrap {

    def init = { servletContext ->
		new Person(firstName:"Sug", lastName:"Arun").save()
		new Person(firstName:"B", lastName:"North").save()
		new Person(firstName:"Abs", lastName:"Hash").save()
		new Person(firstName:"Flavin", lastName:"Flav").save()
		new Person(firstName:"Deano", lastName:"Vooch").save()
		new Person(firstName:"Kristop", lastName:"Vool").save()
		new Person(firstName:"Quotes", lastName:"Stien").save()
		new Person(firstName:"J", lastName:"G").save()
		new Person(firstName:"Mr", lastName:"Commish").save()
    }
    def destroy = {
		Person.findAll().each {
			it.delete()
		}
    }
}
