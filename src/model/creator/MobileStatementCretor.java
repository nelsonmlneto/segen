package model.creator;

import model.statement.MobileStatement;
import model.statement.Statement;
import parser.GambiConstants;
import parser.Token;
import control.TokenListIterator;

public class MobileStatementCretor {

	public static MobileStatement create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		MobileStatement mobile = new MobileStatement();
		Statement statement = null;
		
		if (currentToken.kind != GambiConstants.BEGIN){
			//TODO throw syntax exception (BEGIN expected)
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != GambiConstants.END){
			switch(currentToken.kind){
			    
				case GambiConstants.TARGET:
					statement = SimpleStatementCreator.create(currentToken.image);
					mobile.addStatement(statement);
			    	break;
		            
			    case GambiConstants.CLICKBUTTON:
		            //TODO
		            break;      
		            
		    	case GambiConstants.PROCALL:
		    		//TODO
		            break;      
		            
			    default:
			    	//TODO throw syntax error exception
			}
			
			currentToken = tokenIterator.getNextToken();
		}
		
		return mobile;	
	}
	
}
