package model.creator;

import model.exception.SyntaxException;
import model.statement.Statement;
import model.statement.WebStatement;
import parser.SegenConstants;
import parser.Token;
import control.converter.TokenListIterator;

public class WebStatementCreator {

	public static WebStatement create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		WebStatement web = new WebStatement();
		Statement statement = null;
		
		if (currentToken.kind != SegenConstants.BEGIN){
			throw new SyntaxException("<begin> expected at line " + currentToken.beginLine);
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != SegenConstants.END){
			switch(currentToken.kind){
			    
				case SegenConstants.TARGET:
					statement = SimpleStatementCreator.create(currentToken.image);
			    	break;
		            
			    case SegenConstants.CLICKBUTTON:
			    	statement = ClickButtonStatementCreator.create(tokenIterator);
		            break;     
		            
//		    	case SegenConstants.PROCALL:
//		    		statement = ProcedureCallStatementCreator.create(currentToken.image, tokenIterator);
//		            break;      
		            
			    default:
			    	throw new SyntaxException("Wrong instruction at line " + currentToken.beginLine);
			}
			
			web.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return web;	
	}
	
}
