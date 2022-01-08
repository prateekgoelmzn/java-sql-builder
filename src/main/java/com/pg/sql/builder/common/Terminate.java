package com.pg.sql.builder.common;

public class Terminate {

	private StringBuilder query;

	public Terminate(StringBuilder query) {
		this.query = query;
	}

	public String build() {
		return query.toString().trim();
	}
}