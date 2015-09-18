package model;

import java.util.ArrayList;
import java.util.List;

import model.statement.Statement;

public class SimpleTest {

	private String title;
	
	private List<Statement> statements;
	
	public SimpleTest(String title){
		this.title = title;
		statements = new ArrayList<Statement>();
	}
	
	public void addStatement(Statement statement){
		statements.add(statement);
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public String getTitle() {
		return title;
	}	

}
