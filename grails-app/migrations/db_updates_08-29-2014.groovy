databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1409324349338-1") {
		addColumn(tableName: "person") {
			column(name: "is_inactive", type: "bit") {
				constraints(nullable: "false")
			}
		}
		addColumn(tableName: "category") {
			column(name: "is_inactive", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}
}
