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
	
	public List<Statement> getStatements() {
		return statements;
	}

	@Override
	public String getStatement(){
		String list = "";
		int i = 1;
		for(Statement s : statements){
			list = list + s.getStatement();
			if(i != statements.size()){
				list = list + "\n";
			}
			i++;
		}
		return list;
	}
	
}
