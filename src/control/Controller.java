package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.AfterAll;
import model.BeforeAll;
import model.Procedure;
import model.SimpleTest;
import model.creator.AfterAllCreator;
import model.creator.BeforeAllCreator;
import model.creator.ProcedureCreator;
import model.creator.SimpleTestCreator;
import model.exception.SyntaxException;
import parser.SegenConstants;
import parser.Token;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class Controller {

	private ScriptModel script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	//TODO create a method that calls the other two (organization)
	
	public void createScripts(List<Token> tokens){
		
		try {
			createScriptModel(tokens);
		} catch (SyntaxException e) {
			e.printStackTrace();
		}
			
		try{
			generateTestScripts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void createScriptModel(List<Token> tokens) throws SyntaxException{
		
		script = new ScriptModel();
		
		TokenListIterator tokenIterator = new TokenListIterator(tokens);
		Token currentToken = tokenIterator.getNextToken();
	    
		while (currentToken.kind != SegenConstants.EOF){
			switch(currentToken.kind){
			    
				case SegenConstants.SIMPLETEST:
			        
					SimpleTest test = SimpleTestCreator.create(tokenIterator);
					script.addSimpleTest(test);
					
			    	break;
			 
			    case SegenConstants.PROCEDURE:
			    	
			    	Procedure procedure = ProcedureCreator.create(tokenIterator); 
			    	script.addProcedure(procedure);
		            
			    	break;
			    	
			    case SegenConstants.BEFOREALL:
			    	
			    	if(script.containsBeforeAll()){
			    		throw new SyntaxException("Only one <beforeAll> structure allowed");
			    	}else{
			    		BeforeAll beforeAll = BeforeAllCreator.create(tokenIterator);
			    		script.setBeforeAll(beforeAll);
			    	}
			    	
			    	break;
			    	
			    case SegenConstants.AFTERALL:
			    	
			    	if(script.containsAfterAll()){
			    		throw new SyntaxException("Only one <afterAll> structure allowed");
			    	}else{
			    		AfterAll afterAll = AfterAllCreator.create(tokenIterator);
			    		script.setAfterAll(afterAll);
			    	}
			    	
			    	break;
			    
			    default:
			    	throw new SyntaxException("<simple>, <proc>, <beforeAll> or <afterAll> expected at line " + currentToken.beginLine);
			}
			currentToken = tokenIterator.getNextToken();
		}
		
	}
	
	//TODO
	private void generateTestScripts() throws IOException{
		
		List<MethodSpec> methods = new ArrayList<MethodSpec>();
		MethodSpec method;
		
		for(SimpleTest test : script.getSimpleTests()){
			method = MethodSpec.methodBuilder(test.getTitle())
					.addStatement(test.writeTest())
					.build();
			methods.add(method);
		}

		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
		    .addMethods(methods)
		    .build();

		JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
		    .build();

		
		PrintWriter writer = new PrintWriter("generate_test.java", "UTF-8");
		writer.println(javaFile.toString());
		writer.close();
		
		
	}
	
	public static Controller getInstance(){
		if(_instance == null)
			_instance = new Controller();
		return _instance;	
	}
	
}
