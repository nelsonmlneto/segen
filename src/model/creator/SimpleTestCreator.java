package model.creator;

import model.SimpleTest;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class SimpleTestCreator {

	public static SimpleTest create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		SimpleTest test = null;
		Statement statement = null;
		
		if (currentToken.kind == SegenConstants.IDENT){
			
			test = new SimpleTest(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind != SegenConstants.BEGIN){
				//TODO throw syntax exception (begin expected)
			}
			
		}else{
			//TODO throw syntax exception (test name expected)
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != SegenConstants.END){
			switch(currentToken.kind){
			    
				case SegenConstants.TARGET:
					statement = SimpleStatementCreator.create(currentToken.image);
					break;
			 
			    case SegenConstants.WEB:
			    	statement = WebStatementCreator.create(tokenIterator); 
			    	break;
			    
			    case SegenConstants.MOBILE:
			    	statement = MobileStatementCretor.create(tokenIterator); 
			    	break; 
		            
			    case SegenConstants.CLICKBUTTON:
			    	statement = ClickButtonStatementCreator.create(tokenIterator);
			    	break;  
		            
		    	case SegenConstants.PROCALL:
		    		statement = ProcedureCallStatementCreator.create(currentToken.image, tokenIterator);
		            break;     
		            
			    default:
			    	//TODO throw syntax error exception
			}
			test.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		System.out.println(">> Listing simple test: " + test.getTitle());
		for(Statement t : test.getStatements()){
			System.out.println(t.getStatement());
		}
		System.out.println("");
		
		return test;
	}
	
}
