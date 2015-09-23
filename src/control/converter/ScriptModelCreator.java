package control.converter;

import java.util.List;

import model.AfterAll;
import model.BeforeAll;
import model.Header;
import model.Procedure;
import model.SimpleTest;
import model.creator.AfterAllCreator;
import model.creator.BeforeAllCreator;
import model.creator.HeaderCreator;
import model.creator.ProcedureCreator;
import model.creator.SimpleTestCreator;
import model.exception.SyntaxException;
import parser.SegenConstants;
import parser.Token;

public class ScriptModelCreator {

	public static ScriptModel create(List<Token> tokens) throws SyntaxException{
		
		ScriptModel script = new ScriptModel();
		
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
			    	
		    	case SegenConstants.HEADER:
			    	
			    	if(script.containsHeader()){
			    		throw new SyntaxException("Only one <header> structure allowed");
			    	}else{
			    		Header header = HeaderCreator.create(tokenIterator);
			    		script.setHeader(header);
			    	}
			    	
			    	break;	
			    
			    default:
			    	throw new SyntaxException("<simple>, <proc>, <beforeAll> or <afterAll> expected at line " + currentToken.beginLine);
			}
			currentToken = tokenIterator.getNextToken();
		}
		
		return script;
		
	}
	
}
