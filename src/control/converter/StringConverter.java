package control.converter;

public class StringConverter {

	private String statementsWeb;
	private String statementsMobile;
	
	public StringConverter(){
		this.statementsWeb = "";
		this.statementsMobile = "";
	}
	
	public void addCommonStatement(String statement){
		statementsWeb = statementsWeb + statement + "\n";
		statementsMobile = statementsMobile + statement + "\n";
	}
	
	public void addStatementWeb(String statement){
		statementsWeb = statementsWeb + statement + "\n";
	}
	
	public void addStatementMobile(String statement){
		statementsMobile = statementsMobile + statement + "\n";
	}

	public String getStatementsWeb() {
		return statementsWeb;
	}

	public String getStatementsMobile() {
		return statementsMobile;
	}
	
}
