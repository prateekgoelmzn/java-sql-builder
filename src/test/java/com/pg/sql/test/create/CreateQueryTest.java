package com.pg.sql.test.create;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class CreateQueryTest {
	
	@Test
	public void createQuery() {
		String createQuery = SQLBuilder.write().create()
				.table("Persons")
				.addColumnNameAndDataType("PersonID","int")
				.addColumnNameAndDataType("LastName", "varchar(255)")
				.addColumnNameAndDataType("FirstName", "varchar(255)")
				.addColumnNameAndDataType("Address","varchar(255)")
				.addColumnNameAndDataType("City","varchar(255)")
				.build();
		String expectedCreateQuery = "CREATE TABLE Persons ( PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255) )";
		assertEquals(createQuery,expectedCreateQuery);
	}
}
