package model.creator;

import model.Procedure;
import model.exception.SyntaxException;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class ProcedureCreator {
	
	public static Procedure create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Token currentToken = tokenIterator.getNextToken();
		Procedure procedure = null;
		Statement statement = null;
		
		if (currentToken.kind == SegenConstants.IDENT){
			
			procedure = new Procedure(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind == SegenConstants.PARAM){
				
				procedure.setParameter(currentToken.image);
			
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
			    	throw new SyntaxException("Wrong instruction at line " + currentToken.beginLine);
			}
			procedure.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		System.out.println(">> Listing Procedure: " + procedure.getTitle());
		for(Statement t : procedure.getStatements()){
			System.out.println(t.getStatement());
		}
		System.out.println("");
		
		return procedure;
	}	

}
