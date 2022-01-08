package com.pg.sql.builder.update;

import java.util.ArrayList;
import java.util.List;

import com.pg.sql.builder.common.Condition;
import com.pg.sql.builder.common.Utility;
import com.pg.sql.builder.common.Where;

public class Set {

	StringBuilder query;
	List<Condition> conditions;

	public Set(StringBuilder query, Condition cond) {
		this.query = query;
		conditions = new ArrayList<>();
		conditions.add(cond);
		query.append("SET");
		query.append(" ");
	}

	public Set set(String colName, String value) {
		conditions.add(Condition.instance().setKey(colName).setValue(value));
		return this;
	}

	public Where where() {
		for (int i = 0; i < conditions.size(); i++) {
			query.append(conditions.get(i).getKey());
			query.append("=");
			Utility.getInstance().handleRHSValue(conditions.get(i).getValue(), query);
			if (i != conditions.size() - 1) {
				query.append(",");
				query.append(" ");
			}
		}
		query.append(" ");
		return new Where(query);
	}

}
