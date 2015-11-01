package view;

import java.io.FileInputStream;
import java.io.IOException;

import lexicalAnalyzer.ParseException;
import model.exception.SyntaxException;
import control.Controller;

public class SegenView {
	
	public static String SEGEN_VERSION = "Segen - Selenium and Selendroid scripts generator - version 1.0\n";
	public static String READING = "Reading script from: %s";
	public static String SUCCESS = "\nScripts %s and %s generated successfully";
	
	public static String ERROR_FILE_NOT_FOUND = "ERROR: File  %s  not found";
	public static String ERROR_WRONG_USE = "ERROR: The correct use is java -jar segen.jar [-log] <script>";
	public static String ERROR_SYNTATIC = "ERROR: Syntatic Error";
	public static String ERROR_WRITING = "ERROR: Scripts converted but not generated";
	
	public  static void main(String args[]) {
		System.out.println(SEGEN_VERSION);

		String filename = "";
		String baseFilename = "";
		boolean log = false;
		
		if(args.length == 0){
			System.out.println(ERROR_WRONG_USE);
			System.exit(0);
		}
		
		if(args[0].toLowerCase().equals("-log")){
			log = true;
		}	
		
		filename = args[args.length-1];
		System.out.println(String.format(READING, filename));

		int pos = filename.lastIndexOf(".");	
		if (pos > 0) {
			baseFilename = filename.substring(0, pos);
		}

		try {
			FileInputStream script = new FileInputStream(filename);
			Controller controller = Controller.getInstance();
			controller.setLog(log);
			try {
				controller.createScripts(script, baseFilename);
			} catch (ParseException e) {
				e.printStackTrace();
				System.exit(0);
			} catch (SyntaxException e) {
				System.out.println(ERROR_SYNTATIC);
				System.out.println(e.getMessage());
				System.exit(0);
			} catch (IOException e) {
				System.out.println(ERROR_WRITING);
				System.out.println(e.getMessage());
				System.exit(0);
			}
			System.out.println(String.format(SUCCESS, baseFilename + "_web", baseFilename + "_mobile"));
		}catch (java.io.FileNotFoundException e) {
			System.out.println(String.format(ERROR_FILE_NOT_FOUND, filename));
			return;
		}

	} 
}
