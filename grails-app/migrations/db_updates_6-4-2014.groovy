databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1401882022419-1") {
		addColumn(tableName: "feedback") {
			column(name: "given", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
