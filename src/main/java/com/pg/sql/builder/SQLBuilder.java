package com.pg.sql.builder;

import com.pg.sql.builder.alter.Alter;
import com.pg.sql.builder.create.Create;
import com.pg.sql.builder.delete.Delete;
import com.pg.sql.builder.insert.Insert;
import com.pg.sql.builder.select.Select;
import com.pg.sql.builder.update.Update;

public class SQLBuilder {
	private StringBuilder query;

	private SQLBuilder() {
		query = new StringBuilder();
	}

	public static SQLBuilder write() {
		return new SQLBuilder();
	}

	public Select select() {
		return new Select(query);
	}

	
	  public Insert insert() {
		  return new Insert(query);
	  }
	  
	public Delete delete() {
		return new Delete(query);
	}

	public Update update() {
		return new Update(query);
	}

	public Create create() {
		return new Create(query);
	}

	public Alter alter() {
		return new Alter(query);
	}

}