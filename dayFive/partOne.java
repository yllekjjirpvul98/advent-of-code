package dayFive;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class partOne {
	
	public static boolean isUpperCase(String input) {
		if (input.equals(input.toUpperCase())) {
			return true;
		}else return false;
	}
	
	public static String destroy(String input) {
		for (int i = 0; i < input.length()-1; i++) {
			String firstChar = input.substring(i, i+1);
			String secondChar = input.substring(i+1, i+2);
			if (isUpperCase(firstChar) && secondChar.equals(firstChar.toLowerCase()) ||  !isUpperCase(firstChar) && secondChar.equals(firstChar.toUpperCase())) {
				if (i == 0) {
					return input.substring(2);
				}else if (i == input.length()-1) {
					return input.substring(0, i);
				}else return input.substring(0, i).concat(input.substring(i+2));
			}
		}return input;
	}
	
	public static void main(String[] args) throws IOException{
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayFive/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
		
		while ((line= in.readLine()) != null) {
			String temp = destroy(line);
			String original = line;
			
			while (!temp.equals(original)) {
				original = temp;
				temp = destroy(temp);
			}
			System.out.println(temp.length());
		}
		
		
	}

}
