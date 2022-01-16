package com.pg.sql.builder.delete;

import com.pg.sql.builder.common.Build;
import com.pg.sql.builder.common.From;

public class Delete extends Build {

	private StringBuilder query;

	public Delete(StringBuilder query) {
		super(query);
		this.query = query;
		query.append("DELETE");
		query.append(" ");
	}

	public From from(String table) {
		return new From(query, table);
	}
}