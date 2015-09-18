package model.creator;

import model.statement.ClickButtonStatement;
import parser.Token;
import control.TokenListIterator;

public class ClickButtonStatementCreator {

	public static ClickButtonStatement create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		String buttonId = currentToken.image;
	
		if(!(buttonId.startsWith("[\"") && buttonId.endsWith("\"]"))){
			//TODO throw syntax exception
		}
		
		buttonId.substring(2, buttonId.length() - 2);
		
		return new ClickButtonStatement(buttonId);
	}	
	
}
