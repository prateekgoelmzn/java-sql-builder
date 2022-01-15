package com.pg.sql.builder.alter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pg.sql.builder.common.Build;
import com.pg.sql.builder.common.Column;

public class Add extends Build{

	private StringBuilder query;
	private List<Column> addColumns;

	public Add(StringBuilder query) {
		super(query);
		this.query = query;
		query.append("ADD");
		query.append(" ");
		this.addColumns = new ArrayList<>();
	}

	public Add column(String columnName, String dataType) {
		this.addColumns.add(Column.init(columnName,dataType));
		return this;
	}

	public Add columns(String ... list ) {
		for(String str : Arrays.asList(list)) {
			String[] info = str.split("\\s+");
			this.addColumns.add(Column.init(info[0],info[1]));
		}
		return this;
	}

	@Override
	public String build() {
		query.append("(");
		query.append(" ");
		int i = 0;
		for (Column col : this.addColumns) {
			query.append(col.getName());
			query.append(" ");
			query.append(col.getDataType());
			if (i != this.addColumns.size() - 1) {
				query.append(",");
				query.append(" ");
			}
			i++;
		}
		query.append(")");
		query.append(" ");
		return this.query.toString().trim();
	}
}