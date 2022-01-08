package com.pg.sql.builder.alter;

import com.pg.sql.builder.common.Terminate;

public class Alter {

	private StringBuilder query;

	public Alter(StringBuilder query) {
		query.append("ALTER");
		query.append(" ");
		this.query = query;
	}

	public Alter table(String tablename) {
		query.append("TABLE");
		query.append(" ");
		query.append(tablename);
		query.append(" ");
		return this;
	}

	public Add add() {
		return new Add(query);
	}

	public Terminate modifyColumn(String columnName, String dataType) {
		query.append("MODIFY");
		query.append(" ");
		query.append(columnName);
		query.append(" ");
		query.append(dataType);
		query.append(" ");
		return new Terminate(query);
	}

	public Terminate dropColumn(String columnName) {
		query.append("DROP");
		query.append(" ");
		query.append("COLUMN");
		query.append(" ");
		query.append(columnName);
		query.append(" ");
		return new Terminate(query);
	}

}