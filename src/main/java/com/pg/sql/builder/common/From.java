package com.pg.sql.builder.common;

public class From {
	private StringBuilder query;

	public From(StringBuilder query, String tableName) {
		this.query = query;
		query.append("FROM");
		query.append(" ");
		query.append(tableName);
		query.append(" ");
	}

	public Where where() {
		return new Where(query);
	}

	public String build() {
		return this.query.toString().trim();
	}

}