package model.statement;

public class ProcedureCallStatement extends Statement {
	
	private String title;
	private String arg;
	
	public ProcedureCallStatement(String title, String arg) {
		this.title = title;
		this.arg = arg;
	}
	
	public ProcedureCallStatement(String title) {
		this.title = title;
		this.arg = "";
	}

	@Override
	public String getStatement(){
		//TODO remove, not used
		return "Procedure " + title + " " + arg;
	}
	
	
}
