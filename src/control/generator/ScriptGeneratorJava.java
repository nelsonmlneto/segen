package control.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.AfterAll;
import model.BeforeAll;

import org.junit.Test;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class ScriptGeneratorJava implements ScriptGenerator {

	private String testSuiteName;
	
	private List<MethodSpec> methodsWeb;
	
	private List<MethodSpec> methodsMobile;
	
	private String headerWeb;
	
	private String headerMobile;
	
	private String globalWeb;
	
	private String globalMobile;
	
	public ScriptGeneratorJava(){
		this.methodsWeb = new ArrayList<MethodSpec>();
		this.methodsMobile = new ArrayList<MethodSpec>();
		this.headerWeb = "";
		this.headerMobile = "";
		this.globalWeb = "";
		this.globalMobile = "";
	}
	
	@Override
	public void addTestSuiteName(String testSuiteName){
		this.testSuiteName = testSuiteName;
	}
	
	@Override
	public void setHeaderWeb(String headerWeb) {
		this.headerWeb = headerWeb;
	}

	@Override
	public void setHeaderMobile(String headerMobile) {
		this.headerMobile = headerMobile;
	}
	
	@Override
	public void setGlobalWeb(String globalWeb){
		this.globalWeb = globalWeb;
	}
	
	@Override
	public void setGlobalMobile(String globalMobile){
		this.globalMobile = globalMobile;
	}
	
	@Override
	public void setBeforeAllWeb(String statementsWeb){
		MethodSpec method;
		method = MethodSpec.methodBuilder("setUpAll")
				.addAnnotation(BeforeAll.class)
				.addStatement(statementsWeb)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void setBeforeAllMobile(String statementsMobile){
		MethodSpec method;
		method = MethodSpec.methodBuilder("setUpAll")
				.addAnnotation(BeforeAll.class)
				.addStatement(statementsMobile)
				.build();
		methodsMobile.add(method);
	}

	
	@Override
	public void addTestCaseWeb(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addAnnotation(Test.class)
				.addStatement(statements)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void addTestCaseMobile(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addAnnotation(Test.class)
				.addStatement(statements)
				.build();
		methodsMobile.add(method);
	}
	
	@Override
	public void setAfterAllWeb(String statementsWeb){
		MethodSpec method;
		method = MethodSpec.methodBuilder("tearDownAll")
				.addAnnotation(AfterAll.class)
				.addStatement(statementsWeb)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void setAfterAllMobile(String statementsMobile){
		MethodSpec method;
		method = MethodSpec.methodBuilder("tearDownAll")
				.addAnnotation(AfterAll.class)
				.addStatement(statementsMobile)
				.build();
		methodsMobile.add(method);
	}
	
	@Override
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
		
		String testWebString;
		String poetTest = javaFileWeb.toString();
		String[] parts = poetTest.split("\\{",2);
		testWebString = headerWeb + parts[0] + "{\n" + globalWeb +  parts[1]; 		
		writer.println(testWebString);
		writer.close();
	}
	
	private void generateMobileFile() throws IOException{
		TypeSpec testMob = TypeSpec.classBuilder(testSuiteName)
		    .addMethods(methodsMobile)
		    .build();
		JavaFile javaFileMob = JavaFile.builder("",testMob)
		    .build();

		PrintWriter writer = new PrintWriter(testSuiteName+"_mobile.java", "UTF-8");
		
		String testMobileString;
		String poetTest = javaFileMob.toString();
		String[] parts = poetTest.split("\\{",2);
		testMobileString = headerMobile + parts[0] + "{\n" + globalMobile +  parts[1]; 		
		writer.println(testMobileString);
		writer.close();
		
	}
	
	
	
	
	
}