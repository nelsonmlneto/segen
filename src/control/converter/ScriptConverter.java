package control.converter;

import java.io.IOException;
import java.util.List;

import model.AfterAll;
import model.BeforeAll;
import model.Fields;
import model.Header;
import model.Procedure;
import model.ScriptModel;
import model.SimpleTest;
import model.statement.MobileStatement;
import model.statement.ProcedureCallStatement;
import model.statement.Statement;
import model.statement.WebStatement;
import control.generator.ScriptGenerator;

public class ScriptConverter {

	private static ScriptConverter _instance;
	
	private ScriptModel scriptModel;
	
	private ScriptGenerator generator;
	
	private ScriptConverter(){}
	
	public void convert(ScriptModel scriptModel, ScriptGenerator generator, String testSuiteName) throws IOException{
		this.scriptModel = scriptModel;
		this.generator = generator;
	
		this.generator.addTestSuiteName(testSuiteName);
		
		convertHeader();
		
		convertFields();
		
		convertBeforeAll();

		convertTestCases();
		
		convertAfterAll();
		
		this.generator.generateTestScripts();
		
	}
	
	private void convertHeader(){
		if(scriptModel.containsHeader()){
			Header header = scriptModel.getHeader();
			StringConverter stringCon = convertTestStatements(header.getStatements());
			this.generator.setHeaderWeb(stringCon.getStatementsWeb());
			this.generator.setHeaderMobile(stringCon.getStatementsMobile());
		}
		
			
	}
	
	private void convertFields(){
		if(scriptModel.containsGlobal()){
			Fields fields = scriptModel.getFields();
			StringConverter stringCon = convertTestStatements(fields.getStatements());
			this.generator.setFieldsWeb(stringCon.getStatementsWeb());
			this.generator.setFieldsMobile(stringCon.getStatementsMobile());
		}
		
			
	}
	
	private void convertBeforeAll(){
		if(scriptModel.containsBeforeAll()){
			BeforeAll beforeAll = scriptModel.getBeforeAll();
			StringConverter stringCon = convertTestStatements(beforeAll.getStatements());
			this.generator.setBeforeAllWeb(stringCon.getStatementsWeb());
			this.generator.setBeforeAllMobile(stringCon.getStatementsMobile());	
		}
		
	}
	
	private void convertTestCases(){
		StringConverter stringCon;
		for(SimpleTest test : scriptModel.getSimpleTests()){
			stringCon = convertTestStatements(test.getStatements());
			this.generator.addTestCaseWeb(test.getTitle(), stringCon.getStatementsWeb());
			this.generator.addTestCaseMobile(test.getTitle(), stringCon.getStatementsMobile());
		}
	}
	
	private StringConverter convertTestStatements(List<Statement> testStatList){
		
		StringConverter stringCon = new StringConverter();
		
		for(Statement stat : testStatList){
			if(stat instanceof WebStatement){
				stringCon.addStatementWeb(stat.getStatement());
				
			}else if (stat instanceof MobileStatement){
				stringCon.addStatementMobile(stat.getStatement());
				
			}else if (stat instanceof ProcedureCallStatement){
				ProcedureCallStatement procCall = (ProcedureCallStatement) stat;
				StringConverter stringConProc = convertProcedureStatements(procCall.getTitle(), procCall.getArg());
				stringCon.addStatementWeb(stringConProc.getStatementsWeb());
				stringCon.addStatementMobile(stringConProc.getStatementsMobile());
				
			}else{
				stringCon.addCommonStatement(stat.getStatement());
				
			}	
		}
		return stringCon;
		
	}
	
	private StringConverter convertProcedureStatements(String procedureTitle, String argument){
		
		Procedure proc = this.scriptModel.getProcedures().get(procedureTitle);
		
		if(proc == null){
			//TODO semantic error;
			System.out.println("ERROR");
		}
		
		List<Statement> procList = proc.getStatements();
		StringConverter stringConProc = new StringConverter();
		
		for(Statement stat : procList){
			if(stat instanceof WebStatement){
				WebStatement webStat = (WebStatement) stat;
				stringConProc.addStatementWeb(searchParameterList(webStat.getStatements(), proc.getParameter(), argument));
				
			}else if (stat instanceof MobileStatement){
				MobileStatement mobStat = (MobileStatement) stat;
				stringConProc.addStatementMobile(searchParameterList(mobStat.getStatements(), proc.getParameter(), argument));
				
			}else{
				stringConProc.addCommonStatement(searchParameter(stat.getStatement(),proc.getParameter(), argument));
				
			}	
		}
		return stringConProc;
	}
	
	private String searchParameter(String statement, String parameter, String arg){
		if(parameter.equals(""))
			return statement;
		
		return statement.replaceAll(parameter, arg);
	}
	
	private String searchParameterList(List<Statement> procList, String parameter, String arg){	
		String result = "";
		int i = 1;
		for(Statement s : procList){
			result = result + searchParameter(s.getStatement(),parameter,arg);
			if(i != procList.size()){
				result = result + "\n";
			}
			i++;
		}
		return result;
	}
	
	private void convertAfterAll(){
		
		if(scriptModel.containsAfterAll()){
			AfterAll afterAll = scriptModel.getAfterAll();
			StringConverter stringCon = convertTestStatements(afterAll.getStatements());
			this.generator.setAfterAllWeb(stringCon.getStatementsWeb());
			this.generator.setAfterAllMobile(stringCon.getStatementsMobile());
		}
		
	}
	
	public static ScriptConverter getInstance(){
		if(_instance == null)
			_instance = new ScriptConverter();
		return _instance;	
	}
	
}
