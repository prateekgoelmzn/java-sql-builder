package com.pg.sql.builder.update;

import com.pg.sql.builder.common.Condition;

public class Update {
	private StringBuilder query;

	public Update(StringBuilder query) {
		this.query = query;
		query.append("UPDATE");
		query.append(" ");
	}

	public Update table(String tableName) {
		query.append(tableName);
		query.append(" ");
		return this;
	}

	public Set set(String colname, String newValue) {
		return new Set(query, Condition.instance().setKey(colname).setValue(newValue));
	}
}
