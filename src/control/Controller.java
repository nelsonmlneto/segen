package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import lexicalAnalyzer.LexicalAnalyzer;
import lexicalAnalyzer.ParseException;
import model.ScriptModel;
import model.creator.ScriptModelCreator;
import model.exception.SyntaxException;
import lexicalAnalyzer.Token;
import control.converter.ScriptConverter;
import control.generator.ScriptGeneratorJava;

public class Controller {

	private ScriptModel script;
	
	private static Controller _instance;
	
	private Controller(){}
	
	public void createScripts(FileInputStream file, String testSuiteName){
				
//		List<Token> tokens;
//		try {
//			tokens = LexicalAnalyzer.analyze(file);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		try {
			List<Token> tokens = LexicalAnalyzer.analyze(file);
			script = ScriptModelCreator.create(tokens);
		} catch (SyntaxException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
