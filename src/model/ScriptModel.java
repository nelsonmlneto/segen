package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptModel {

	private List<SimpleTest> simpleTests;
	private Map<String,Procedure> procedures;
	private BeforeAll beforeAll;
	private AfterAll afterAll;
	private Header header;
	private Fields fields;
	
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

	public List<SimpleTest> getSimpleTests() {
		return simpleTests;
	}

	public void setSimpleTests(List<SimpleTest> simpleTests) {
		this.simpleTests = simpleTests;
	}

	public Map<String, Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(Map<String, Procedure> procedures) {
		this.procedures = procedures;
	}

	public BeforeAll getBeforeAll() {
		return beforeAll;
	}

	public void setBeforeAll(BeforeAll beforeAll) {
		this.beforeAll = beforeAll;
	}
	
	public boolean containsBeforeAll(){
		if(this.beforeAll == null)
			return false;
		return true;
	}

	public AfterAll getAfterAll() {
		return afterAll;
	}

	public void setAfterAll(AfterAll afterAll) {
		this.afterAll = afterAll;
	}
	
	public boolean containsAfterAll(){
		if(this.afterAll == null)
			return false;
		return true;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	public boolean containsHeader(){
		if(this.header == null)
			return false;
		return true;
	}	
	
	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	public boolean containsGlobal(){
		if(this.fields == null)
			return false;
		return true;
	}
	
	
	
}
