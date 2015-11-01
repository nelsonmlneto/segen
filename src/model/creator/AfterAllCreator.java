package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.AfterAll;
import model.exception.SyntaxException;
import model.statement.Statement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;

public class AfterAllCreator {
	
	public static AfterAll create(TokenListIterator tokenIterator) throws SyntaxException{
		
		AfterAll afterAll = new AfterAll();
		Statement statement = null;
		
		Token currentToken = tokenIterator.getNextToken();
		
		if(currentToken.kind != SegenConstants.BEGIN){
			throw new SyntaxException("<begin> expected at line " + currentToken.beginLine);
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
		            
			    default:
			    	throw new SyntaxException("Instruction not allowed for <afterAll> at line " + currentToken.beginLine);
			}
			afterAll.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return afterAll;

	}	
}
