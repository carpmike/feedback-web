databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1404739036150-1") {
		addColumn(tableName: "reminder") {
			column(name: "text", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
	changeSet(author: "mcarpenter", id: "1404739036150-2") {
		grailsChange {
			change {
				def grantUser = new feedback.web.User(username: 'grant', enabled: true, password: 'gr@n+', email: 'gtliddle@gmail.com').save(flush: true)
		        feedback.web.UserRole.create grantUser, feedback.web.Role.findByAuthority('ROLE_USER'), true
			}
		}	
	}	
}
