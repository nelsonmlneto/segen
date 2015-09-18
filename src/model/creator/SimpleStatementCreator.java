package model.creator;

import model.statement.SimpleStatement;

public class SimpleStatementCreator {

	public static SimpleStatement create(String statement){
		return new SimpleStatement(statement);
	}
	
}
