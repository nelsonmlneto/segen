package model;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

	private String title;
	
	private List<Statement> statements;
	
	public SimpleTest(String title){
		this.title = title;
		statements = new ArrayList<Statement>();
	}
	
}
