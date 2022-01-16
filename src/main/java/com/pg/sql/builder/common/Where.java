package com.pg.sql.builder.common;

import java.util.Arrays;
import java.util.List;

public class Where extends Build {
	private StringBuilder query;

	public Where(StringBuilder query) {
		super(query);
		this.query = query;
		query.append("WHERE");
		query.append(" ");
	}

	public Where isEqual(String lhs, Object rhs) {
		query.append(lhs);
		query.append("=");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isNotEqual(String lhs, Object rhs) {
		query.append(lhs);
		query.append("!=");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isLessThen(String lhs, Object rhs) {
		query.append(lhs);
		query.append("<");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isGreaterThen(String lhs, Object rhs) {
		query.append(lhs);
		query.append(">");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isGreaterEqual(String lhs, Object rhs) {
		query.append(lhs);
		query.append(">=");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isLessEqual(String lhs, Object rhs) {
		query.append(lhs);
		query.append("<=");
		Utility.getInstance().handleRHSValue(rhs, query);
		query.append(" ");
		return this;
	}

	public Where isNull(String lhs) {
		query.append(lhs);
		query.append("=");
		query.append("NULL");
		query.append(" ");
		return this;
	}

	public Where isBetween(String colName, Object firstVal, Object secondVal) {
		query.append(colName);
		query.append(" ");
		query.append("BETWEEN");
		query.append(" ");
		Utility.getInstance().handleRHSValue(firstVal, query);
		query.append(" ");
		query.append("AND");
		query.append(" ");
		Utility.getInstance().handleRHSValue(secondVal, query);
		query.append(" ");
		return this;
	}

	public Where in(String colName, Object... listValues) {
		List<Object> list = Arrays.asList(listValues);
		query.append(colName);
		query.append(" ");
		query.append("IN");
		query.append(" ");
		query.append("(");
		int i = 0;
		for (Object ele : list) {
			Utility.getInstance().handleRHSValue(ele, query);
			if (i != list.size() - 1) {
				query.append(",");
			}
			i++;
		}
		query.append(")");
		query.append(" ");
		return this;
	}

	public <T> Where in(String colName, List<T> list) {
		query.append(colName);
		query.append(" ");
		query.append("IN");
		query.append(" ");
		query.append("(");
		int i = 0;
		for (Object ele : list) {
			Utility.getInstance().handleRHSValue(ele, query);
			if (i != list.size() - 1) {
				query.append(",");
			}
			i++;
		}
		query.append(")");
		query.append(" ");
		return this;
	}

	public Where in(String colName, String qry) {
		query.append(colName);
		query.append(" ");
		query.append("IN");
		query.append(" ");
		query.append("(");
		query.append(qry);
		query.append(")");
		query.append(" ");
		return this;
	}

	public Where andIsEqual(String lhs, Object rhs) {
		query.append("AND");
		query.append(" ");
		return isEqual(lhs, rhs);
	}

	public Where andIsNotEqual(String lhs, Object rhs) {
		query.append("AND");
		query.append(" ");
		return isNotEqual(lhs, rhs);
	}

	public Where andIsNull(String colName) {
		query.append("AND");
		query.append(" ");
		return isNull(colName);
	}

	public Where andIsGreaterThen(String colName, Object value) {
		query.append("AND");
		query.append(" ");
		return isGreaterThen(colName, value);
	}

	public Where andIsGreaterEqual(String colName, Object value) {
		query.append("AND");
		query.append(" ");
		return isGreaterEqual(colName, value);
	}

	public Where andIsLessThen(String colName, Object value) {
		query.append("AND");
		query.append(" ");
		return isLessThen(colName, value);
	}

	public Where andIsLessEqual(String colName, Object value) {
		query.append("AND");
		query.append(" ");
		return isLessEqual(colName, value);
	}

	public Where andBetween(String colName, Object firstVal, Object secondVal) {
		query.append("AND");
		query.append(" ");
		return isBetween(colName, firstVal, secondVal);
	}

	public Where andIn(String colName, Object... listValues) {
		query.append("AND");
		query.append(" ");
		return in(colName, listValues);
	}

	public Where andIn(String colName, String qry) {
		query.append("AND");
		query.append(" ");
		return in(colName, qry);
	}

	public Where orderBy(String... strings) {
		query.append("ORDER BY");
		query.append(" ");
		List<String> list = Arrays.asList(strings);
		String lastEle = (list.get(list.size() - 1));
		String order = null;
		int size = list.size();
		if (lastEle.equals("ASC") || lastEle.equals("DESC")) {
			order = lastEle;
			size = size - 1;
		}
		for (int i = 0; i < size; i++) {
			query.append(list.get(i));
			if (i != size - 1) {
				query.append(",");
			}
			query.append(" ");
		}
		if (order != null) {
			query.append(order);
		}
		query.append(" ");
		return this;
	}

}