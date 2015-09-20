package control;

import java.util.List;

import model.Procedure;
import model.SimpleTest;
import model.creator.ProcedureCreator;
import model.creator.SimpleTestCreator;
import model.exception.SyntaxException;
import parser.SegenConstants;
import parser.Token;

public class Controller {

	private ScriptModel script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	//TODO create a method that calls the other two (organization)
	
	public void createScripts(List<Token> tokens){
		
		try {
			createScriptModel(tokens);
			generateTestScripts();
		} catch (SyntaxException e) {
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
			    
			    default:
			    	throw new SyntaxException("<simple> or <proc> expected at line " + currentToken.beginLine);
			}
			currentToken = tokenIterator.getNextToken();
		}
		
	}
	
	//TODO
	private void generateTestScripts(){
		
	}
	
	public static Controller getInstance(){
		if(_instance == null)
			_instance = new Controller();
		return _instance;	
	}
	
}
