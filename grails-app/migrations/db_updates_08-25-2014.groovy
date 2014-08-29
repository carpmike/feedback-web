databaseChangeLog = {
	changeSet(author: "mcarpenter", id: "1404739037000-1") {
		grailsChange {
			change {
				def sherrylUser = new feedback.web.User(username: 'sherryl', enabled: true, password: '5h3rry1', email: 'sherryl.nufer@pareto-consulting.com').save(flush: true)
		        feedback.web.UserRole.create sherrylUser, feedback.web.Role.findByAuthority('ROLE_USER'), true
				def fioreUser = new feedback.web.User(username: 'fiore', enabled: true, password: 'f10r3', email: 'fiore.londino@pareto-consulting.com').save(flush: true)
		        feedback.web.UserRole.create fioreUser, feedback.web.Role.findByAuthority('ROLE_USER'), true
			}
		}	
	}	
}
