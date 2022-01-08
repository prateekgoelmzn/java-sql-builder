package com.pg.sql.test.insert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class InsertQueryTest {
	
	@Test
	public void insertQuery() {
		String insertQuery = SQLBuilder.write().insert()
				.into("Employee")
				.columns("CustomerName", "ContactName", "Address", "City", "PostalCode", "Country")
				.values("Cardinal", "Tom B. Erichsen", "Skagen 21", "Stavanger", "4006", "Norway")
				.build();
		String expectedInsertQuery = "INSERT INTO Employee (CustomerName,ContactName,Address,City,PostalCode,Country) VALUES ('Cardinal','Tom B. Erichsen','Skagen 21','Stavanger','4006','Norway')";
		assertEquals(insertQuery,expectedInsertQuery);
	}
}