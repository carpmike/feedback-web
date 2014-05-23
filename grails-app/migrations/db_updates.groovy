databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1400848514442-1") {
		addColumn(tableName: "user") {
			column(name: "email", type: "varchar(255)")
		}

		grailsChange {
			change {
				def mikeUser = feedback.web.User.findByUsername('mike')
				mikeUser.email = 'carpmike@gmail.com'
				mikeUser.save(flush: true)

				def adminUser = feedback.web.User.findByUsername('admin')
				adminUser.email = 'carpmike+@gmail.com'
				adminUser.save(flush: true)
			}
		}

		addNotNullConstraint(tableName: "user", columnName: "email", columnDataType: "varchar(255)")
		addUniqueConstraint(tableName: "user", columnNames: "email")
	}

	changeSet(author: "mcarpenter (generated)", id: "1400848514442-2") {
		createIndex(indexName: "email_uniq_1400848513740", tableName: "user", unique: "true") {
			column(name: "email")
		}
	}

	changeSet(author: "mcarpenter", id: "1400848514442-3") {
		grailsChange {
			change {
				def deanUser = new feedback.web.User(username: 'deano', enabled: true, password: 'd3@n0', email: 'deansalvucci3@gmail.com').save(flush: true)
		        feedback.web.UserRole.create deanUser, feedback.web.Role.findByAuthority('ROLE_USER'), true
				def jenUser = new feedback.web.User(username: 'jen', enabled: true, password: 'j3nn1f3r', email: 'jbtomer@gmail.com').save(flush: true)
		        feedback.web.UserRole.create jenUser, feedback.web.Role.findByAuthority('ROLE_USER'), true
			}
		}	
	}

}