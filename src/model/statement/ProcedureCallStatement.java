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

	public String getTitle() {
		return title;
	}

	public String getArg() {
		return arg;
	}	
}
