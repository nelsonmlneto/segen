package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.exception.SyntaxException;
import model.statement.ClickButtonStatement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;

public class ClickButtonStatementCreator {

	public static ClickButtonStatement create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		String buttonId = currentToken.image;
	
		if(currentToken.kind != SegenConstants.ARG){
			throw new SyntaxException("Button ID expected at line " + currentToken.beginLine);
		}
		
		buttonId = buttonId.substring(2, buttonId.length() - 2);
		
		return new ClickButtonStatement(buttonId);
	}	
	
}
