package model.creator;

import model.statement.MobileStatement;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class MobileStatementCretor {

	public static MobileStatement create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		MobileStatement mobile = new MobileStatement();
		Statement statement = null;
		
		if (currentToken.kind != SegenConstants.BEGIN){
			//TODO throw syntax exception (BEGIN expected)
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
		            
		    	case SegenConstants.PROCALL:
		    		statement = ProcedureCallStatementCreator.create(currentToken.image, tokenIterator);
		            break;      
		            
			    default:
			    	//TODO throw syntax error exception
			}
			
			mobile.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return mobile;	
	}
	
}
