package control;

import java.io.IOException;
import java.util.List;

import model.exception.SyntaxException;
import parser.Token;
import control.converter.ScriptConverter;
import control.converter.ScriptModel;
import control.converter.ScriptModelCreator;
import control.generator.ScriptGeneratorJava;

public class Controller {

	private ScriptModel script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	public void createScripts(List<Token> tokens, String testSuiteName){
		
		try {
			script = ScriptModelCreator.create(tokens);
		} catch (SyntaxException e) {
			e.printStackTrace();
		}	

		try {
			ScriptConverter converter = ScriptConverter.getInstance();
			ScriptGeneratorJava generator = new ScriptGeneratorJava();
			converter.convert(script, generator, testSuiteName);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	}
	
	public static Controller getInstance(){
		if(_instance == null)
			_instance = new Controller();
		return _instance;	
	}
	
}
