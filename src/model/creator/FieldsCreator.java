package model.creator;

import lexicalAnalyzer.SegenConstants;
import lexicalAnalyzer.Token;
import model.Fields;
import model.exception.SyntaxException;
import model.statement.Statement;
import control.converter.TokenListIterator;

public class FieldsCreator {

	public static Fields create(TokenListIterator tokenIterator) throws SyntaxException{
		
		Fields fields = new Fields();
		Statement statement = null;
		
		Token currentToken = tokenIterator.getNextToken();
		
		if(currentToken.kind != SegenConstants.BEGIN){
			throw new SyntaxException("<begin> expected at line " + currentToken.beginLine);
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
		            
			    default:
			    	throw new SyntaxException("Instruction not allowed for <fields> at line " + currentToken.beginLine);
			}
			fields.addStatement(statement);
			currentToken = tokenIterator.getNextToken();
		}
		
		
		return fields;

	}


}
