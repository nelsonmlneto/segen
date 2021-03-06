package control.converter;

import java.util.List;

import lexicalAnalyzer.Token;

public class TokenListIterator {
	
	private List<Token> tokens;
	
	private int position;
	
	public TokenListIterator(List<Token> tokens){
		this.tokens = tokens;
		position = 0;
	}
	
	public Token getNextToken(){
		Token next = tokens.get(position);
		position++;
		return next;
	}

}
