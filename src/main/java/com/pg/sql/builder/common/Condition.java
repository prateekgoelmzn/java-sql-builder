package com.pg.sql.builder.common;

public class Condition {
	private String key;
	private Object value;

	public String getKey() {
		return key;
	}

	public Condition setKey(String key) {
		this.key = key;
		return this;
	}

	public Object getValue() {
		return value;
	}

	public Condition setValue(Object value) {
		this.value = value;
		return this;
	}

	public static Condition instance() {
		return new Condition();
	}
}