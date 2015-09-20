package model.creator;

import model.statement.ProcedureCallStatement;
import parser.SegenConstants;
import parser.Token;
import control.TokenListIterator;

public class ProcedureCallStatementCreator {
	
	public static ProcedureCallStatement create(String title, TokenListIterator tokenIterator){
		
		ProcedureCallStatement procedureCall = null;
		
		title = title.substring(1, title.length() - 1);
		
		Token currentToken = tokenIterator.getNextToken();
		
		if(currentToken.kind == SegenConstants.ARG){
			String arg = currentToken.image;
			arg = arg.substring(1, arg.length() - 1);
			procedureCall = new ProcedureCallStatement(title, arg);
			
		}else if (currentToken.kind == SegenConstants.EMPTYPARAM){
			procedureCall = new ProcedureCallStatement(title);
			
		}else{
			//TODO throw syntax exception
		}
		
		return procedureCall;
		
	}	

}
