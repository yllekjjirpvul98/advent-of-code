package dayOne;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class partTwo {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayOne/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    int result = 0;
	    HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
	    boolean found = false;
	    while (true) {
			    while ((line = in.readLine()) != null) {
			    	char symbol = line.toCharArray()[0];
			    	char[] character = java.util.Arrays.copyOfRange(line.toCharArray(), 1, line.toCharArray().length);
			    	Integer number = 0;
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
			    	if (frequency.containsKey(result)) {
			    		System.out.println(result);
			    		found = true;
			    		break;
			    	}else {
			    		frequency.put(result, 1);
			    	}
		    }
			if (found) {
				break;
			}else {
				in.close();
				inputStream = new FileInputStream("../advent_of_code/src/advent_of_code/input.txt");
				reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				in = new BufferedReader(reader);
			}  
	    }  
	}
}
