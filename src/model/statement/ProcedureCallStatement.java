package model.statement;

public class ProcedureCallStatement extends Statement {
	
	private String procedureId;
	private String parameter;
	
	public ProcedureCallStatement(String procedureId, String parameter) {
		this.procedureId = procedureId;
		this.parameter = parameter;
	}
	
	public ProcedureCallStatement(String procedureId) {
		this.procedureId = procedureId;
	}

	@Override
	public String getStatement(){
		//TODO remove, not used
		return "Procedure " + procedureId + " " + parameter;
	}
	
	
}
