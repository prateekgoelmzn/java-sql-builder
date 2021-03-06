package com.pg.sql.test.select;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;
import com.pg.sql.builder.common.Order;

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
		String selectInQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.where()
				.in("empId",  "abc","def","ghi","jkl")
				.build();
		String expectedSelectInQuery = "SELECT * FROM Employee WHERE empId IN ('abc','def','ghi','jkl')";
		assertEquals(selectInQuery,expectedSelectInQuery);
	}
	
	@Test
	public void selectInStringsQuery() {
		String selectInStringsQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.where()
				.in("empId", Arrays.asList( "abc","def","ghi","jkl"))
				.build();
		String expectedSelectInStringsQuery = "SELECT * FROM Employee WHERE empId IN ('abc','def','ghi','jkl')";
		assertEquals(selectInStringsQuery,expectedSelectInStringsQuery);
	}
	
	@Test
	public void selectInIntegerQuery() {
		String selectInIntegerQuery = SQLBuilder.write().select()
				.all()
				.from("Employee")
				.where()
				.in("empId", Arrays.asList( 1234,321,456,9875))
				.build();
		String expectedSelectInIntegerQuery = "SELECT * FROM Employee WHERE empId IN (1234,321,456,9875)";
		assertEquals(selectInIntegerQuery,expectedSelectInIntegerQuery);
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
	public void selectColumnsQuery() {
		String selectColumnsQuery = SQLBuilder.write().select()
				.columns(Arrays.asList("empname","empSalary","empDepratment"))
				.from("Employee")
				.where().isEqual("EmployeeName","ABCD")
				.andBetween("EmployeeAge", 21, 30)
				.build();
		String expectedSelectColumnsQuery = "SELECT empname,empSalary,empDepratment FROM Employee WHERE EmployeeName='ABCD' AND EmployeeAge BETWEEN 21 AND 30";
		assertEquals(selectColumnsQuery,expectedSelectColumnsQuery);
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
	
	@Test
	public void selectJoinQuery() {
		String selectJoinQuery = SQLBuilder.write().select()
				.columns("s.last_name","s.first_name","p.course_code"," p.status"," p.amount")
				.from("enrollment e")
				.join("join", "student s")
				.on("s.id", "e.student_id")
				.join("join", "payment p")
				.on("p.course_code","e.course_code")
				.and("p.student_id","e.student_id")
				.build();
		String expectedSelectJoinQuery = "SELECT s.last_name,s.first_name,p.course_code, p.status, p.amount FROM enrollment e join student s ON s.id=e.student_id join payment p ON p.course_code=e.course_code AND p.student_id=e.student_id";
		assertEquals(selectJoinQuery,expectedSelectJoinQuery);
	}
	
	@Test
	public void selectOrderByQuery() {
		String selectOrderByQuery = SQLBuilder.write()
				.select().all()
				.from("supplier")
				.orderBy("last_name",Order.DESC)
				.build();
		String expectedSelectOrderByQuery = "SELECT * FROM supplier ORDER BY last_name DESC";
		assertEquals(selectOrderByQuery,expectedSelectOrderByQuery);
	}
}
