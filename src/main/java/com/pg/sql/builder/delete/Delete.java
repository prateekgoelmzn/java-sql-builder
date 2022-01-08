package com.pg.sql.builder.delete;

import com.pg.sql.builder.common.From;

public class Delete {

	private StringBuilder query;

	public Delete(StringBuilder query) {
		this.query = query;
		query.append("DELETE");
		query.append(" ");
	}

	public From from(String table) {
		return new From(query, table);
	}

	public String build() {
		return query.toString().trim();
	}

}