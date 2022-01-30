package com.pg.sql.builder;

import com.pg.sql.builder.alter.Alter;
import com.pg.sql.builder.create.Create;
import com.pg.sql.builder.delete.Delete;
import com.pg.sql.builder.drop.Drop;
import com.pg.sql.builder.insert.Insert;
import com.pg.sql.builder.select.Select;
import com.pg.sql.builder.update.Update;

public class SQLBuilder {
	private StringBuilder query;

	private SQLBuilder() {
		query = new StringBuilder();
	}

	/**
	 * This method use to create instance of SQLBuilder to write different DDL and
	 * DML sql queries.
	 * 
	 * @return SQLBuilder
	 */
	public static SQLBuilder write() {
		return new SQLBuilder();
	}

	/**
	 * This method use to create instance of SELECT query.
	 * 
	 * @return Select
	 */
	public Select select() {
		return new Select(query);
	}

	/**
	 * This method use to create instance of INSERT query.
	 * 
	 * @return Insert
	 */
	public Insert insert() {
		return new Insert(query);
	}

	/**
	 * This method use to create instance of DELETE query.
	 * 
	 * @return Delete
	 */
	public Delete delete() {
		return new Delete(query);
	}

	/**
	 * This method use to create instance of UPDATE query.
	 * 
	 * @return Update
	 */
	public Update update() {
		return new Update(query);
	}

	/**
	 * This method use to create instance of CREATE query.
	 * 
	 * @return Create
	 */
	public Create create() {
		return new Create(query);
	}

	/**
	 * This method use to create instance of ALTER query.
	 * 
	 * @return Alter
	 */
	public Alter alter() {
		return new Alter(query);
	}

	/**
	 * This method use to create instance of DROP query.
	 * 
	 * @return Drop
	 */
	public Drop drop() {
		return new Drop(query);
	}

}