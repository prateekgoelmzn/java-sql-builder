package com.pg.sql.builder.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pg.sql.builder.common.From;

public class Select {

	private StringBuilder query;
	private List<String> selectColumns;
	private boolean isAllSelected = false;

	public Select(StringBuilder query) {
		this.selectColumns = new ArrayList<>();
		this.query = query;
		query.append("SELECT");
		query.append(" ");
	}

	public Select distinct() {
		query.append("DISTINCT");
		query.append(" ");
		return this;
	}

	public Select column(String colName) {
		this.selectColumns.add(colName);
		return this;
	}

	public Select columns(String ... columnList ) {
		this.selectColumns.addAll(Arrays.asList(columnList));
		return this;
	}

	public Select all() {
		query.append("*");
		query.append(" ");
		this.isAllSelected = true;
		return this;
	}

	public From from(String tableName) {
		if (!this.isAllSelected && !selectColumns.isEmpty()) {
			int i = 0;
			for (String col : selectColumns) {
				query.append("");
				query.append(col);
				if (i != selectColumns.size() - 1) {
					query.append(",");
				}
				i++;
			}
			query.append(" ");
		}
		return new From(query, tableName);
	}

}