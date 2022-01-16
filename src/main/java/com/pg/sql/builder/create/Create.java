package com.pg.sql.builder.create;

import java.util.ArrayList;
import java.util.List;

import com.pg.sql.builder.common.Build;
import com.pg.sql.builder.common.Column;

public class Create extends Build {

	private StringBuilder query;
	private List<Column> columns;

	public Create(StringBuilder query) {
		super(query);
		this.query = query;
		query.append("CREATE");
		query.append(" ");
		columns = new ArrayList<>();
	}

	public Create table(String tableName) {
		query.append("TABLE");
		query.append(" ");
		query.append(tableName);
		query.append(" ");
		return this;
	}

	public Create addColumnNameAndDataType(String colName, String dataType) {
		this.columns.add(Column.init(colName, dataType));
		return this;
	}

	private void createColumnString() {
		query.append("(");
		query.append(" ");
		for (int i = 0; i < columns.size(); i++) {
			query.append(columns.get(i).getName());
			query.append(" ");
			query.append(columns.get(i).getDataType());
			if (i != columns.size() - 1) {
				query.append(",");
				query.append(" ");
			}
		}
		query.append(" ");
		query.append(")");
	}

	@Override
	public String build() {
		createColumnString();
		return query.toString().trim();
	}

}
