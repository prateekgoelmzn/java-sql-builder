package com.pg.sql.builder.common;

public class Terminate extends Build {

	private StringBuilder query;

	public Terminate(StringBuilder query) {
		super(query);
		this.query = query;
	}
}