databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1409336322419-1") {
		addColumn(tableName: "category") {
			column(name: "is_inactive", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
