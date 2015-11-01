package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.BeforeAll;
import model.exception.SyntaxException;
import model.statement.Statement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;
public class BeforeAllCreator {
	
	public static BeforeAll create(TokenListIterator tokenIterator) throws SyntaxException{
		
		BeforeAll beforeAll = new BeforeAll();
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
			    	throw new SyntaxException("Instruction not allowed for <beforeAll> at line " + currentToken.beginLine);
			}
			beforeAll.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return beforeAll;

	}	
}
