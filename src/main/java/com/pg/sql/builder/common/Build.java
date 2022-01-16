package com.pg.sql.builder.common;

public class Build {

	private StringBuilder query;

	public Build(StringBuilder query) {
		this.query = query;
	}

	public String build() {
		return query.toString().trim();
	}
}
