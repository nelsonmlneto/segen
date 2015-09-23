package model.creator;

import model.Header;
import model.exception.SyntaxException;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.converter.TokenListIterator;

public class HeaderCreator {

	public static Header create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Header header = new Header();
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
			    	throw new SyntaxException("Wrong instruction for <beforeAll> at line " + currentToken.beginLine);
			}
			header.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		
		return header;

	}
	
}
