import feedback.web.Person

class BootStrap {

    def init = { servletContext ->
		new Person(firstName:"Mike", lastName:"Carpenter").save()
		new Person(firstName:"Lori", lastName:"Carpenter").save()
    }
    def destroy = {
		Person.findAll().each {
			it.delete()
		}
    }
}
