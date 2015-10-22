package view;

import java.io.FileInputStream;

import control.Controller;

public class SegenView {
	 
	public  static void main(String args[]) {
		System.out.println("Starting Segen ... ");

		String filename = "";
		String baseFilename = "";

		filename = args[args.length-1];
		System.out.println("Reading file " + filename + " . . .");

		int pos = filename.lastIndexOf(".");	
		if (pos > 0) {
			baseFilename = filename.substring(0, pos);
		}

		try {
			FileInputStream script = new FileInputStream(filename);
			Controller controller = Controller.getInstance();
			controller.createScripts(script, baseFilename);
			
		}catch (java.io.FileNotFoundException e) {
			System.out.println("File " + filename + " not found");
			return;
		}

	} 
}
