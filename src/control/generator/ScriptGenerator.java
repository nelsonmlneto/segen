package control.generator;

import java.io.IOException;

public interface ScriptGenerator {
	
	public void addTestSuiteName(String testSuiteName);
	
	public void setHeaderWeb(String headerWeb);
	
	public void setHeaderMobile(String headerMobile);
	
	public void setFieldsWeb(String globalWeb);
	
	public void setFieldsMobile(String globalMobile);
	
	public void setBeforeAllWeb(String statementsWeb);
	
	public void setBeforeAllMobile(String statementsMobile);
	
	public void addTestCaseWeb(String title, String statements);
	
	public void addTestCaseMobile(String title, String statements);
	
	public void setAfterAllWeb(String statementsWeb);
	
	public void setAfterAllMobile(String statementsMobile);
	
	public void generateTestScripts() throws IOException;
	
}
