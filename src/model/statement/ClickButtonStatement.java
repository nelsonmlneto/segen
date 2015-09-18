package model.statement;

public class ClickButtonStatement extends Statement {

	private String CLICK_BUTTON_JAVA = "driver.findElement(By.id(\"$ID$\")).click();";
	
	private String statement;
	
	public ClickButtonStatement(String buttonId){
		statement = CLICK_BUTTON_JAVA;
		statement.replaceFirst("$ID$", buttonId);
	}
	
	@Override
	public String getStatement(){
		return statement;
	}
}
