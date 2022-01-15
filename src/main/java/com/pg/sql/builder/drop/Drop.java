package com.pg.sql.builder.drop;

import com.pg.sql.builder.common.Build;

public class Drop extends Build{
	private StringBuilder query;

	public Drop(StringBuilder query) {
		super(query);
		this.query = query;
		query.append("DROP");
		query.append(" ");
	}

	public Drop table(String table) {
		query.append("TABLE");
		query.append(" ");
		query.append(table);
		return this;
	}
}
