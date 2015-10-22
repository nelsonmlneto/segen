package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.exception.SyntaxException;
import model.statement.MobileStatement;
import model.statement.Statement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;

public class MobileStatementCretor {

	public static MobileStatement create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		MobileStatement mobile = new MobileStatement();
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
			
			mobile.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return mobile;	
	}
	
}
