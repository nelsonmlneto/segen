package model.creator;

import parser.GambiConstants;
import parser.Token;
import model.SimpleTest;
import control.TokenListIterator;

public class SimpleTestCreator {

	public static SimpleTest create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		
		SimpleTest test = null;
		
	    
		if (currentToken.kind == GambiConstants.TARGET){
			
			test = new SimpleTest(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind != GambiConstants.BEGIN){
				//TODO throw syntax exception (begin expected)
			}
			
		}else{
			//TODO throw syntax exception (test name expected)
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != GambiConstants.EOF){
			switch(currentToken.kind){
			    
				case GambiConstants.TARGET:

					
			    	break;
			 
			    case GambiConstants.PROCEDURE:
			            
		            break;
			    
			    default:
			    	//TODO throw syntax error exception
			}
			currentToken = tokenIterator.getNextToken();
		}
		
		
		return test;
	}
	
}
