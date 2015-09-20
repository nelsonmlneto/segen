package model.creator;

import model.SimpleTest;
import model.exception.SyntaxException;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class SimpleTestCreator {

	public static SimpleTest create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		SimpleTest test = null;
		Statement statement = null;
		
		if (currentToken.kind == SegenConstants.IDENT){
			
			test = new SimpleTest(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind != SegenConstants.BEGIN){
				throw new SyntaxException("<begin> expected at line " + currentToken.beginLine);
			}
			
		}else{
			throw new SyntaxException("Test title expected at line " + currentToken.beginLine);
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
			    	throw new SyntaxException("Wrong instruction at line " + currentToken.beginLine);
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
