package dayTwo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class partOne {
	public static void main(String[] args) throws IOException {
	    InputStream inputStream = new FileInputStream("../advent_of_code/src/dayTwo/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    int numOfTwo = 0;
	    int numOfThree = 0;
	    String line;
	    while ((line = in.readLine()) != null) {
	    	HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	    	for (Character c : line.toCharArray()) {
	    		if (count.containsKey(c)) {
	    			count.put(c, count.get(c)+1);
	    		}else count.put(c, 1);
	    	}
	    	if (count.containsValue(2)) {
		        numOfTwo += 1;
		    }
		    if (count.containsValue(3)) {
		        numOfThree += 1;
		    }
	    }System.out.println(numOfTwo * numOfThree);
	}

}
