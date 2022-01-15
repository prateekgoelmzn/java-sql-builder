package com.pg.sql.test.drop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pg.sql.builder.SQLBuilder;

public class DropQueryTest {
	@Test
	public void dropQuery() {
		String dropQuery  =  SQLBuilder.write()
				.drop()
				.table("customers")
				.build();
		String expectedDropQuery = "DROP TABLE customers";
		assertEquals(dropQuery,expectedDropQuery);
	}
}
