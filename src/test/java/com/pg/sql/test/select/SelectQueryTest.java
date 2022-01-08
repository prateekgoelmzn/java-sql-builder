package com.pg.sql.test.select;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class SelectQueryTest {
	
	@Test
	public void selectAllQuery() {
		String selectAllQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.build();
		String expectedSelectAllQuery = "SELECT * FROM Employee";
		assertEquals(selectAllQuery,expectedSelectAllQuery);
	}

	@Test
	public void selectInQuery() {
		String selectAllQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.where()
				.in("empId", "1234","321","456","9875")
				.build();
		String expectedSelectAllQuery = "SELECT * FROM Employee WHERE empId IN ('1234','321','456','9875')";
		assertEquals(selectAllQuery,expectedSelectAllQuery);
	}
	
	@Test
	public void selectAllWhereQuery() {
		String selectAllQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.where().isEqual("EmployeeName","ABCD")
				.andBetween("EmployeeAge", 21, 30)
				.build();
		String expectedSelectAllQuery = "SELECT * FROM Employee WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30";
		assertEquals(selectAllQuery,expectedSelectAllQuery);
	}
	
	@Test
	public void selectColumnWhereQuery() {
		String selectAllQuery = SQLBuilder.write().select()
				.columns("empname","empSalary")
				.from("Employee")
				.where().isEqual("EmployeeName","ABCD")
				.andBetween("EmployeeAge", 21, 30)
				.build();
		String expectedSelectAllQuery = "SELECT empname,empSalary FROM Employee WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30";
		assertEquals(selectAllQuery,expectedSelectAllQuery);
	}
	
	@Test
	public void selectColumnWhereAndQuery() {
		String selectAllQuery = SQLBuilder.write().select()
				.columns("empname","empSalary")
				.from("Employee")
				.where().isEqual("EmployeeName","ABCD")
				.andBetween("EmployeeAge", 21, 30)
				.andIsEqual("empDept", "ABCD")
				.andIsGreaterThen("empage", 34)
				.build();
		String expectedSelectAllQuery = "SELECT empname,empSalary FROM Employee WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30 AND empDept='ABCD' AND empage>34";
		assertEquals(selectAllQuery,expectedSelectAllQuery);
	}
}
