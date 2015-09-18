package model.statement;

import java.util.ArrayList;
import java.util.List;

public class WebStatement extends Statement {

	private List<Statement> statements;
	
	public WebStatement(){
		statements = new ArrayList<Statement>();
	}
	
	public void addStatement(Statement statement){
		statements.add(statement);
	}
	
	@Override
	public String getStatement(){
		//TODO iterate statement
		return "";
	}
	
}
