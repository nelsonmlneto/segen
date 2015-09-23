package control.generator;

import java.io.IOException;

public interface ScriptsGenerator {

	public void addTestSuiteName(String testSuiteName);
	
	public void addTestCaseWeb(String title, String statements);
	
	public void addTestCaseMobile(String title, String statements);
	
	public void generateTestScripts() throws IOException;
	
}
