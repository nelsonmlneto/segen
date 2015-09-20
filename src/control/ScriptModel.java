package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Procedure;
import model.SimpleTest;

public class ScriptModel {

	private List<SimpleTest> simpleTests;
	private Map<String,Procedure> procedures;
	
	public ScriptModel(){
		simpleTests = new ArrayList<SimpleTest>();
		procedures = new HashMap<String, Procedure>();
	}
	
	public void addSimpleTest(SimpleTest test){
		simpleTests.add(test);
	}
	
	public void addProcedure(Procedure procedure){
		procedures.put(procedure.getTitle(), procedure);
		//TODO verify throw exception existing title (procedure);
	}
	
}
