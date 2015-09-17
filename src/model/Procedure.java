package model;

import java.util.List;

public class Procedure {
	
	private String title;
	
	private String parameter;
	
	private List<Statement> statements;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
