package model.creator;

import model.Procedure;
import model.statement.Statement;
import parser.GambiConstants;
import parser.Token;
import control.TokenListIterator;

public class ProcedureCreator {
	
	public static Procedure create(TokenListIterator tokenIterator){
		
		Token currentToken = tokenIterator.getNextToken();
		Procedure procedure = null;
		Statement statement = null;
		
		if (currentToken.kind == GambiConstants.IDENT){
			
			procedure = new Procedure(currentToken.toString());
			currentToken = tokenIterator.getNextToken();
			
			if(currentToken.kind == GambiConstants.PARAM){
				
				procedure.setParameter(currentToken.image);
			
			}else if(currentToken.kind == GambiConstants.EMPTYPARAM){
				
				procedure.setParameter("");
			
			}else{
				//TODO throw syntax exception parameter expected
			}
			
			if(tokenIterator.getNextToken().kind != GambiConstants.BEGIN){
				//TODO throw syntax exception (begin expected)
			}
			
		}else{
			//TODO throw syntax exception (test name expected)
		}
		
		currentToken = tokenIterator.getNextToken();
		
		while (currentToken.kind != GambiConstants.END){
			switch(currentToken.kind){
			    
				case GambiConstants.TARGET:
					statement = SimpleStatementCreator.create(currentToken.image);
					break;
			 
			    case GambiConstants.WEB:
			    	statement = WebStatementCreator.create(tokenIterator); 
			    	break;
			    
			    case GambiConstants.MOBILE:
			    	statement = MobileStatementCretor.create(tokenIterator); 
			    	break; 
		            
			    case GambiConstants.CLICKBUTTON:
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
