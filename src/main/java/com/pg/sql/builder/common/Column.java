package com.pg.sql.builder.common;

public class Column {
	private String name;
	private String dataType;

	private Column() {
	}
	
	private Column(String name, String dataType) {
		this.name = name;
		this.dataType = dataType;
	}
	
	public static Column init(String name, String datatype) {
		return new Column(name, datatype);
	}

	public String getName() {
		return name;
	}

	public Column setName(String name) {
		this.name = name;
		return this;
	}

	public String getDataType() {
		return dataType;
	}

	public Column setDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

}