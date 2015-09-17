package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Procedure;
import model.SimpleTest;

public class ScriptModel {

	private List<SimpleTest> simpleTests;
	private Map<String,Procedure> procedures;
	
	public ScriptModel(){
		simpleTests = new ArrayList<SimpleTest>();
		//TODO create 
	}
	
	public void addSimpleTest(SimpleTest test){
		simpleTests.add(test);
	}
	
	public void addProcedure(Procedure procedure){
		procedures.put(procedure.getTitle(), procedure);
		
		//TODO throw execption existing title
		
	}
	
}
