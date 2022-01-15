package com.pg.sql.builder.common;

import java.util.Arrays;
import java.util.List;

public class From extends Build{
	private StringBuilder query;

	public From(StringBuilder query, String tableName) {
		super(query);
		this.query = query;
		query.append("FROM");
		query.append(" ");
		query.append(tableName);
		query.append(" ");
	}

	public Where where() {
		return new Where(query);
	}
	
	public From join(String typeOfJoin, String tableName) {
		query.append(typeOfJoin);
		query.append(" ");
		query.append(tableName);
		query.append(" ");
		return this;
	}
	
	public From on(String lhs, String rhs) {
		query.append("ON");
		query.append(" ");
		query.append(lhs);
		query.append("=");
		query.append(rhs);
		query.append(" ");
		return this;
	}
	
	public From and(String lhs, String rhs) {
		query.append("AND");
		query.append(" ");
		query.append(lhs);
		query.append("=");
		query.append(rhs);
		query.append(" ");
		return this;
	}
	
	public From orderBy( String ...strings) {
		query.append("ORDER BY");
		query.append(" ");
		List<String> list = Arrays.asList(strings);
		String lastEle = (list.get(list.size()-1));
		String order = null;
		int size = list.size();
		if (lastEle.equals("ASC") || lastEle.equals("DESC")){
			order = lastEle;
			size = size-1;
		}
		for(int i=0;i<size;i++) {
			query.append(list.get(i));
			if(i!=size-1) {
				query.append(",");
			}
			query.append(" ");
		}
		if(order!=null) {
			query.append(order);
		}
		query.append(" ");
		return this;
	}

}