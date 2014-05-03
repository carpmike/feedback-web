databaseChangeLog = {

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-1") {
		createTable(tableName: "authentication_token") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "authenticatioPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "token_value", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-2") {
		createTable(tableName: "category") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "categoryPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-3") {
		createTable(tableName: "feedback") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "feedbackPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "feedback_type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "text", type: "varchar(255)")

			column(name: "user_id", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-4") {
		createTable(tableName: "feedback_type") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "feedback_typePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(12)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-5") {
		createTable(tableName: "person") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-6") {
		createTable(tableName: "reminder") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "reminderPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "feedback_type_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-7") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-8") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-9") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-10") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-16") {
		createIndex(indexName: "FKF495EB858E22523D", tableName: "feedback") {
			column(name: "category_id")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-17") {
		createIndex(indexName: "FKF495EB85B354939D", tableName: "feedback") {
			column(name: "person_id")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-18") {
		createIndex(indexName: "FKF495EB85B76C51A8", tableName: "feedback") {
			column(name: "feedback_type_id")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-19") {
		createIndex(indexName: "authority_uniq_1398116690812", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-20") {
		createIndex(indexName: "username_uniq_1398116690818", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-21") {
		createIndex(indexName: "FK143BF46A25FDDC9D", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-22") {
		createIndex(indexName: "FK143BF46A80D318BD", tableName: "user_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-11") {
		addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "feedback", constraintName: "FKF495EB858E22523D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "category", referencesUniqueColumn: "false")
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-12") {
		addForeignKeyConstraint(baseColumnNames: "feedback_type_id", baseTableName: "feedback", constraintName: "FKF495EB85B76C51A8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "feedback_type", referencesUniqueColumn: "false")
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-13") {
		addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "feedback", constraintName: "FKF495EB85B354939D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-14") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A80D318BD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "mcarpenter (generated)", id: "1398116691080-15") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A25FDDC9D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
