package control.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class ScriptGeneratorJava implements ScriptsGenerator {

	private String testSuiteName;
	
	private List<MethodSpec> methodsWeb;
	
	private List<MethodSpec> methodsMobile;
	
	public ScriptGeneratorJava(){
		this.methodsWeb = new ArrayList<MethodSpec>();
		this.methodsMobile = new ArrayList<MethodSpec>();
	}
	
	public void addTestSuiteName(String testSuiteName){
		this.testSuiteName = testSuiteName;
	}
	
	public void addTestCaseWeb(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addStatement(statements)
				.build();
		methodsWeb.add(method);
	}
	
	public void addTestCaseMobile(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addStatement(statements)
				.build();
		methodsMobile.add(method);
	}
	
	public void generateTestScripts() throws IOException{
		 generateWebFile();
		 generateMobileFile();
	}
	
	private void generateWebFile() throws IOException{
		TypeSpec testWeb = TypeSpec.classBuilder(testSuiteName)
		    .addMethods(methodsWeb)
		    .build();
		JavaFile javaFileWeb = JavaFile.builder("",testWeb)
		    .build();

		PrintWriter writer = new PrintWriter(testSuiteName+"_web.java", "UTF-8");
		writer.println(javaFileWeb.toString());
		writer.close();
	}
	
	private void generateMobileFile() throws IOException{
		TypeSpec testMob = TypeSpec.classBuilder(testSuiteName)
		    .addMethods(methodsMobile)
		    .build();
		JavaFile javaFileMob = JavaFile.builder("",testMob)
		    .build();

		PrintWriter writer = new PrintWriter(testSuiteName+"_mobile.java", "UTF-8");
		writer.println(javaFileMob.toString());
		writer.close();
	}
	
	
	
}