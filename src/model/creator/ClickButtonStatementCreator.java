package model.creator;

import model.statement.ClickButtonStatement;
import parser.GambiConstants;
import parser.Token;
import control.TokenListIterator;

public class ClickButtonStatementCreator {

	public static ClickButtonStatement create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		String buttonId = currentToken.image;
	
		if(currentToken.kind != GambiConstants.ARG){
			//TODO throw syntax exception
		}
		
		buttonId = buttonId.substring(2, buttonId.length() - 2);
		
		return new ClickButtonStatement(buttonId);
	}	
	
}
