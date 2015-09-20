package model.creator;

import model.statement.Statement;
import model.statement.WebStatement;
import parser.GambiConstants;
import parser.Token;
import control.TokenListIterator;

public class WebStatementCreator {

	public static WebStatement create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		WebStatement web = new WebStatement();
		Statement statement = null;
		
		if (currentToken.kind != GambiConstants.BEGIN){
			//TODO throw syntax exception (BEGIN expected)
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != GambiConstants.END){
			switch(currentToken.kind){
			    
				case GambiConstants.TARGET:
					statement = SimpleStatementCreator.create(currentToken.image);
			    	break;
		            
			    case GambiConstants.CLICKBUTTON:
			    	statement = ClickButtonStatementCreator.create(tokenIterator);
		            break;     
		            
		    	case GambiConstants.PROCALL:
		    		statement = ProcedureCallStatementCreator.create(currentToken.image, tokenIterator);
		            break;      
		            
			    default:
			    	//TODO throw syntax error exception
			}
			
			web.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return web;	
	}
	
}
