package model;

import java.util.ArrayList;
import java.util.List;

import model.statement.Statement;

public class Procedure {
	
	private String title;
	
	private String parameter;
	
	private List<Statement> statements;

	public Procedure(String title) {
		this.title = title;
		statements = new ArrayList<Statement>();
	}
	
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
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
