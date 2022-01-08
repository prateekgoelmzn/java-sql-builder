package com.pg.sql.test.update;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class UpdateQueryTest {
	
	@Test
	public void updateQuery() {
		String updateQuery = SQLBuilder.write().update()
				.table("Customers")
				.set("ContactName","Alfred Schmidt")
				.set("City", "Frankfurt")
				.where().isEqual("CustomerID", 1)
				.build();
		String expectedUpdateQuery = "UPDATE Customers SET ContactName='Alfred Schmidt', City='Frankfurt' WHERE CustomerID=1";
		assertEquals(updateQuery,expectedUpdateQuery);
	}
}
