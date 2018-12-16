package dayOne;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class dayOne {
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayOne/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    int result = 0;
	    while ((line = in.readLine()) != null) {
	    	char symbol = line.toCharArray()[0];
	    	char[] character = java.util.Arrays.copyOfRange(line.toCharArray(), 1, line.toCharArray().length);
	    	int number = 0;
	    	String s = "";
	    	for (char c : character) {
	    		s += c;
	    	}
	    	number = Integer.parseInt(s);
	    	if (symbol == '+') {
	    		result += number;
	    	}else if (symbol == '-') {
	    		result -= number;
	    	}
	    }System.out.println(result);
	}
}
