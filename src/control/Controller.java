package control;

import java.util.List;

import model.Procedure;
import model.SimpleTest;
import model.creator.ProcedureCreator;
import model.creator.SimpleTestCreator;
import parser.GambiConstants;
import parser.Token;

public class Controller {

	private ScriptModel script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	//TODO create a method that calls the other two (organization)
	//TODO rename Gambi name in the jj file
	
	public void createScripts(List<Token> tokens){
		
		createScriptModel(tokens);
		generateTestScripts();
		
	}
	
	private void createScriptModel(List<Token> tokens){
		
		script = new ScriptModel();
		
		TokenListIterator tokenIterator = new TokenListIterator(tokens);
		Token currentToken = tokenIterator.getNextToken();
	    
		while (currentToken.kind != GambiConstants.EOF){
			switch(currentToken.kind){
			    
				case GambiConstants.SIMPLETEST:
			        
					SimpleTest test = SimpleTestCreator.create(tokenIterator);
					script.addSimpleTest(test);
					
			    	break;
			 
			    case GambiConstants.PROCEDURE:
			    	
			    	Procedure procedure = ProcedureCreator.create(tokenIterator); 
			    	script.addProcedure(procedure);
		            
			    	break;
			    
			    default:
			    	//TODO throw syntax error exception
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
