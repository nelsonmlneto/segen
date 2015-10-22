package view;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "0-{ 04{ 03455{ 6";
		String[] parts = string.split("\\{",2);
		String part1 = parts[0]; 
		String part2 = parts[1]; 
		
		System.out.println(part1 + " " + part2);
	}

}
