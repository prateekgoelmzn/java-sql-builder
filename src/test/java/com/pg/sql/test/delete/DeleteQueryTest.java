package com.pg.sql.test.delete;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class DeleteQueryTest {
	
	@Test
	public void deleteQuery() {
		String delQuery  =  SQLBuilder.write().delete()
				.from("Customers")
				.build();
		String expectedDelQuery = "DELETE FROM Customers";
		assertEquals(delQuery,expectedDelQuery);
	}
	
	@Test
	public void deleteWhereQuery() {
		String delQuery  =  SQLBuilder.write().delete()
				.from("Customers")
				.where().isEqual("CustomerName", "Alfreds Futterkiste")
				.build();
		String expectedDelQuery = "DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste'";
		assertEquals(delQuery,expectedDelQuery);
	}
}
