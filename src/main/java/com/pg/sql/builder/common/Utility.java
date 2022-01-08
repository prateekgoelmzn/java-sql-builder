package com.pg.sql.builder.common;


public class Utility {

	private static Utility instance;

	private Utility() {
	}

	public static Utility getInstance() {
		if (instance == null) {
			instance = new Utility();
		}
		return instance;
	}

	public void handleRHSValue(Object obj, StringBuilder query) {
		if (obj instanceof String) {
			query.append("'" + (String) obj + "'");
		} else {
			query.append(obj);
		}
	}
}
