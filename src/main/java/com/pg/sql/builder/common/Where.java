package com.pg.sql.builder.common;

import java.util.Arrays;
import java.util.List;

public class Where {
	private StringBuilder query;

	public Where(StringBuilder query) {
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

	public Where in(String colName, Object ... listValues) {
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

	public Where andIn(String colName, Object ... listValues) {
		query.append("AND");
		query.append(" ");
		return in(colName, listValues);
	}

	public Where andIn(String colName, String qry) {
		query.append("AND");
		query.append(" ");
		return in(colName, qry);
	}

	public String build() {
		return query.toString().trim();
	}
}