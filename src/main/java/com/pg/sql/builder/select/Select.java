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

	/**
	 * This method use to select distinct columns
	 * 
	 * @return Select
	 */
	public Select distinct() {
		query.append("DISTINCT");
		query.append(" ");
		return this;
	}

	/**
	 * This method is used to select only single column which name passed into this
	 * method as argument.
	 * <p>
	 * Here is an example of how this method can be used: <blockquote>
	 * 
	 * <pre>
	 * column("colName");
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * Another example is below if u want to call column using alias name of table
	 * <blockquote>
	 * 
	 * <pre>
	 * column("aliasname.colName");
	 * </pre>
	 * 
	 * </blockquote>
	 * @param colName
	 * @return Select
	 */
	public Select column(String colName) {
		this.selectColumns.add(colName);
		return this;
	}

	/**
	 * This method is used to select only columns which name passed into this method
	 * as arguments.
	 * <p>
	 * Here is an example of how this method can be used: <blockquote>
	 * 
	 * <pre>
	 * columns("colName1", "colName2", "colName3");
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * Another example is below if u want to call columns using alias name of table
	 * <blockquote>
	 * 
	 * <pre>
	 * columns("aliasname.colName1", "aliasname.colName2", "aliasname.colName3");
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param columnList
	 * @return Select
	 */
	public Select columns(String... columnList) {
		this.selectColumns.addAll(Arrays.asList(columnList));
		return this;
	}

	/**
	 * This method is used to select only columns which name passed into this method
	 * as list.
	 * <p>
	 * Here is an example of how this method can be used: <blockquote>
	 * 
	 * <pre>
	 * List<String> columnList = Arrays.asList("colName1", "colName2", "colName3");
	 * columns(columnList);
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * Another example is below if u want to call columns using alias name of table
	 * <blockquote>
	 * 
	 * <pre>
	 * List<String> columnList = Arrays.asList("aliasname.colName1", "aliasname.colName2", "aliasname.colName3");
	 * columns(columnList);
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param columnList
	 * @return Select
	 */
	public Select columns(List<String> columnList) {
		this.selectColumns.addAll(columnList);
		return this;
	}

	/**
	 * This method is used to select all columns.
	 * 
	 * @return Select
	 */
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