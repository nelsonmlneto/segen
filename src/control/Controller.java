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
	
	private boolean log; 
	
	private static Controller _instance;
	
	private Controller(){}
	
	public void createScripts(FileInputStream file, String testSuiteName) throws ParseException, SyntaxException, IOException{
		
		//Lexical Analysis
		List<Token> tokens = LexicalAnalyzer.analyze(file,log);
		
		//Script Model Creation
		script = ScriptModelCreator.create(tokens);

		//Final Scripts Conversion and Generation
		ScriptConverter converter = ScriptConverter.getInstance();
		ScriptGeneratorJava generator = new ScriptGeneratorJava();
		converter.convert(script, generator, testSuiteName);
		
	}
	
	public void setLog(boolean log) {
		this.log = log;
	}
	
	public static Controller getInstance(){
		if(_instance == null)
			_instance = new Controller();
		return _instance;	
	}
	
}
