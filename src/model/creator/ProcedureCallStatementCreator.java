package model.creator;

import lexicalAnalyzer.SegenConstants;
import model.exception.SyntaxException;
import model.statement.ProcedureCallStatement;
import lexicalAnalyzer.Token;
import control.converter.TokenListIterator;

public class ProcedureCallStatementCreator {
	
	public static ProcedureCallStatement create(String title, TokenListIterator tokenIterator) throws SyntaxException{
		
		ProcedureCallStatement procedureCall = null;
		
		title = title.substring(1, title.length());
		
		Token currentToken = tokenIterator.getNextToken();
		
		if(currentToken.kind == SegenConstants.ARG){
			String arg = currentToken.image;
			arg = arg.substring(1, arg.length() - 1);
			procedureCall = new ProcedureCallStatement(title, arg);
			
		}else if (currentToken.kind == SegenConstants.EMPTYPARAM){
			procedureCall = new ProcedureCallStatement(title);
			
		}else{
			throw new SyntaxException("<[]> expected at line " + currentToken.beginLine);
		}
		
		return procedureCall;
		
	}	

}
