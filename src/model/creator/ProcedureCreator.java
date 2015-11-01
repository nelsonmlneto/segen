package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.Procedure;
import model.exception.SyntaxException;
import model.statement.Statement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;

public class ProcedureCreator {
	
	public static Procedure create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		Procedure procedure = null;
		Statement statement = null;
		
		if (currentToken.kind == SegenConstants.IDENT){
			
			procedure = new Procedure(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind == SegenConstants.PARAM){
				String param = currentToken.image;
				param = "\\$"+param.substring(1, param.length() - 1);
				procedure.setParameter(param);
			
			}else if(currentToken.kind == SegenConstants.EMPTYPARAM){
				
				procedure.setParameter("");
			
			}else{
				throw new SyntaxException("<[]> expected at line after procedure declaration at line " + currentToken.beginLine);
			}
			
			if(tokenIterator.getNextToken().kind != SegenConstants.BEGIN){
				throw new SyntaxException("<begin> expected at line " + currentToken.beginLine);
			}
			
		}else{
			throw new SyntaxException("Procedure title expected at line " + currentToken.beginLine);
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
		            
			    case SegenConstants.CLICKBUTTON:
			    	statement = ClickButtonStatementCreator.create(tokenIterator);
			    	break;  	            
		            
			    default:
			    	throw new SyntaxException("Instruction not allowed at line " + currentToken.beginLine);
			}
			procedure.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		return procedure;
	}	

}
