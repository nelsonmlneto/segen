package model.statement;


public class SimpleStatement extends Statement {

	private String statement;
	
	public SimpleStatement(String statement){
		this.statement = statement;
	}
	
	@Override
	public String getStatement(){
		return statement;
	}
	
}
