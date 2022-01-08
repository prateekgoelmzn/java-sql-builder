package com.pg.sql.builder.insert;

import java.util.Arrays;
import java.util.List;

import com.pg.sql.builder.common.Terminate;
import com.pg.sql.builder.common.Utility;

public class Insert {
	
	private StringBuilder query;
	
	public Insert(StringBuilder query) {
		this.query = query;
		query.append("INSERT");
		query.append(" ");
	}
	
	public Insert into(String tableName) {
		query.append("INTO");
		query.append(" ");
		query.append(tableName);
		query.append(" ");
		return this;
	}
	
	public Insert columns(Object ... columnValues ) {
		List<Object> columns = Arrays.asList(columnValues);
		query.append("(");
		for(int i=0;i<columns.size();i++) {
			query.append(columns.get(i));
			if(i!=columns.size()-1) {
				query.append(",");
			}
		}
		query.append(")");
		query.append(" ");
		return this;
	}
	
	public Terminate values(Object ... valueValues ) {
		List<Object> values = Arrays.asList(valueValues);
		query.append("VALUES");
		query.append(" ");
		query.append("(");
		for(int i=0;i<values.size();i++) {
			Utility.getInstance().handleRHSValue(values.get(i), query);
			if(i!=values.size()-1) {
				query.append(",");
			}
		}
		query.append(")");
		return new Terminate(query);
	}

}
