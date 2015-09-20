package model;

import java.util.ArrayList;
import java.util.List;

import model.statement.Statement;

public class BeforeAll {
	
	private List<Statement> statements;
	
	public BeforeAll(){
		statements = new ArrayList<Statement>();
	}
	

	public void addStatement(Statement statement){
		statements.add(statement);
	}

	public List<Statement> getStatements() {
		return statements;
	}

}
