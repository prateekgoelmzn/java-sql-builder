package com.pg.sql.test.alter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class AlterQueryTest {
	
	@Test
	public void alterAddColumnQueryTest() {
		String alterAddQuery = SQLBuilder.write().alter()
				.table("Student")
				.add().column("AGE" ,"number(3)")
				.build();
		String expectedAlterAddQuery = "ALTER TABLE Student ADD ( AGE number(3))";
		assertEquals(alterAddQuery, expectedAlterAddQuery);
	}
	
	@Test
	public void alterAddMultipleColumnsQueryTest() {
		String alterAddQuery = SQLBuilder.write().alter()
				.table("Student")
				.add().columns("AGE number(3)","COURSE varchar(40)")
				.build();
		String expectedAlterAddQuery = "ALTER TABLE Student ADD ( AGE number(3), COURSE varchar(40))";
		assertEquals(alterAddQuery, expectedAlterAddQuery);
	}
	
	@Test
	public void alterModifyColumnQueryTest() {
		String alterModifyQuery = SQLBuilder.write().alter()
				.table("Student")
				.modifyColumn("COURSE", "varchar(20)")
				.build();
		String expectedAlterModifyQuery = "ALTER TABLE Student MODIFY COURSE varchar(20)";
		assertEquals(alterModifyQuery, expectedAlterModifyQuery);
	}
	
	@Test
	public void alterDropColumnQueryTest() {
		String alterDropQuery = SQLBuilder.write().alter()
				.table("Student")
				.dropColumn("COURSE")
				.build();
		String expectedAlterDropQuery = "ALTER TABLE Student DROP COLUMN COURSE";
		assertEquals(alterDropQuery, expectedAlterDropQuery);
	}
	
}
