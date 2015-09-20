package model.statement;

public class ClickButtonStatement extends Statement {

	private String CLICK_BUTTON_JAVA = "driver.findElement(By.id(\"%s\")).click();";
	
	private String statement;
	
	public ClickButtonStatement(String buttonId){
		statement = String.format(CLICK_BUTTON_JAVA, buttonId);
	}
	
	@Override
	public String getStatement(){
		return statement;
	}
}
