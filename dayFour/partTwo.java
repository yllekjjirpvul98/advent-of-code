package dayFour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class partTwo {
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayFour/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    
	    //sort the input file in chronological order
	    ArrayList<String> input = new ArrayList<String>();
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	    while ((line = in.readLine()) != null) {
	    	input.add(line);
	    }
	    Collections.sort(input);
	    
	    int guard = 0;
	    int start = 0;
	    int end = 0;
	    for (String s : input) {
	    	String[] two = s.split("] ", 2);
	    	String time = two [0];
	    	String action = two [1];
	    	if (action.startsWith("Guard")) {
	    		guard = Integer.parseInt(action.split(" ")[1].substring(1));
	    	}else if (action.startsWith("falls")) {
	    		start = Integer.parseInt(time.split(" ")[1].split(":")[1]);
	    	}else if (action.startsWith("wakes")) {
	    		end = Integer.parseInt(time.split(" ")[1].split(":")[1]);
	    		for (int i=start; i < end; i++) {
	    			if (map.containsKey(i)) {
	    				map.get(i).add(guard);
	    			}else {
	    				ArrayList<Integer> integer = new ArrayList<Integer>();
	    				integer.add(guard);
	    				map.put(i, integer);
	    			}
	    		}
	    		start = 0;
	    		end = 0;
	    	}
	    }
	    int max = 0;
    	int maxGuard = 0;
	    for (Integer min : map.keySet()) {
	    	HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
	    	for (Integer g : map.get(min)) {
	    		if (counter.containsKey(g)) {
	    			counter.put(g, counter.get(g)+1);
	    		}else counter.put(g, 1);
	    	}
	    	for (Integer g : counter.keySet()) {
	    		if (counter.get(g) > max) {
	    			max = counter.get(g);
	    			maxGuard = g;
	    			System.out.println(min);
	    		}
	    	}
	    }
	    System.out.println(maxGuard);
	}
}