package control.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class ScriptGeneratorJava implements ScriptGenerator {

	private String testSuiteName;
	
	private List<MethodSpec> methodsWeb;
	
	private List<MethodSpec> methodsMobile;
	
	private String headerWeb;
	
	private String headerMobile;
	
	private String globalWeb;
	
	private String globalMobile;
	
	private String SELENIUM_IMPORT = "import org.openqa.selenium.*;";
	
	private String SELENDROID_IMPORT = "import io.selendroid.client.*;\nimport io.selendroid.common.*;";
	
	public ScriptGeneratorJava(){
		this.methodsWeb = new ArrayList<MethodSpec>();
		this.methodsMobile = new ArrayList<MethodSpec>();
		this.headerWeb = this.SELENIUM_IMPORT + "\n";
		this.headerMobile = this.SELENIUM_IMPORT + "\n" + this.SELENDROID_IMPORT + "\n";
		this.globalWeb = "";
		this.globalMobile = "";
	}
	
	@Override
	public void addTestSuiteName(String testSuiteName){
		this.testSuiteName = testSuiteName;
	}
	
	@Override
	public void setHeaderWeb(String headerWeb) {
		this.headerWeb = this.headerWeb + headerWeb + "\n";
	}

	@Override
	public void setHeaderMobile(String headerMobile) {
		this.headerMobile = this.headerMobile + headerMobile + "\n";
	}
	
	@Override
	public void setFieldsWeb(String globalWeb){
		this.globalWeb = globalWeb;
	}
	
	@Override
	public void setFieldsMobile(String globalMobile){
		this.globalMobile = globalMobile;
	}
	
	@Override
	public void setBeforeAllWeb(String statementsWeb){
		MethodSpec method;
		method = MethodSpec.methodBuilder("setUpAll")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addAnnotation(BeforeClass.class)
				.addStatement(statementsWeb)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void setBeforeAllMobile(String statementsMobile){
		MethodSpec method;
		method = MethodSpec.methodBuilder("setUpAll")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addAnnotation(BeforeClass.class)
				.addStatement(statementsMobile)
				.build();
		methodsMobile.add(method);
	}

	
	@Override
	public void addTestCaseWeb(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Test.class)
				.addStatement(statements)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void addTestCaseMobile(String title, String statements){
		MethodSpec method;
		method = MethodSpec.methodBuilder(title)
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Test.class)
				.addStatement(statements)
				.build();
		methodsMobile.add(method);
	}
	
	@Override
	public void setAfterAllWeb(String statementsWeb){
		MethodSpec method;
		method = MethodSpec.methodBuilder("tearDownAll")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addAnnotation(AfterClass.class)
				.addStatement(statementsWeb)
				.build();
		methodsWeb.add(method);
	}
	
	@Override
	public void setAfterAllMobile(String statementsMobile){
		MethodSpec method;
		method = MethodSpec.methodBuilder("tearDownAll")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.addAnnotation(AfterClass.class)
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
			.addModifiers(Modifier.PUBLIC)		
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
			.addModifiers(Modifier.PUBLIC)	
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