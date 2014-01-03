import feedback.web.*

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
		
		new Category(name:"Presentation").save()
		new Category(name:"Communication").save()
		new Category(name:"Work Product").save()
		new Category(name:"Helping").save()
		new Category(name:"Coaching").save()
		new Category(name:"Listening").save()
    }
    def destroy = {
		Person.findAll().each {
			it.delete()
		}
    }
}
