package control;

import java.util.List;

import model.SimpleTest;
import model.creator.SimpleTestCreator;
import parser.GambiConstants;
import parser.Token;

public class Controller {

	private ScriptModel _script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	//TODO create a method that calls the other two (organization)
	//TODO rename Gambi name in the jj file
	
	public void createScriptModel(List<Token> tokens){
		
		TokenListIterator tokenIterator = new TokenListIterator(tokens);
		
		Token currentToken = tokenIterator.getNextToken();
	    
		while (currentToken.kind != GambiConstants.EOF){
			switch(currentToken.kind){
			    
				case GambiConstants.SIMPLETEST:
			        
					SimpleTest test = SimpleTestCreator.create(tokenIterator);
					_script.addSimpleTest(test);
					
					//TODO throw exception from simple test creator
					
			    	break;
			 
			    case GambiConstants.PROCEDURE:
			            
		            break;
			    
			    default:
			    	//TODO throw syntax error exception
			}
			currentToken = tokenIterator.getNextToken();
		}
		
	}
	
	//TODO
	public void generateTestScripts(){
		
	}
	
	public static Controller getInstance(){
		if(_instance == null)
			_instance = new Controller();
		return _instance;	
	}
	
}
