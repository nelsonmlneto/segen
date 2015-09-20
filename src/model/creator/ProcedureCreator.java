package model.creator;

import model.Procedure;
import model.statement.Statement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class ProcedureCreator {
	
	public static Procedure create(TokenListIterator tokenIterator){
		
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
				//TODO throw syntax exception parameter expected
			}
			
			if(tokenIterator.getNextToken().kind != SegenConstants.BEGIN){
				//TODO throw syntax exception (begin expected)
			}
			
		}else{
			//TODO throw syntax exception (test name expected)
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
			    	//TODO throw syntax error exception
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
