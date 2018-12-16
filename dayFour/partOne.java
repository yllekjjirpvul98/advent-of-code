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

public class partOne {
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayFour/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    
	    //sort the input file in chronological order
	    ArrayList<String> input = new ArrayList<String>();
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
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
	    		ArrayList<Integer> sleep = new ArrayList<Integer>();
	    		for (int i = start; i < end; i++) {
	    			sleep.add(i);
	    		}
	    		start = 0;
	    		end = 0;
	    		if (map.containsKey(guard)) {
	    			map.get(guard).addAll(sleep);
	    		}else {
	    			map.put(guard, sleep);
	    		}	
	    	}
	    }
	    
	    Integer max = 0;
        Integer maxGuard = 0;
	    for (Integer g : map.keySet()) {
	    	if (map.get(g).size() > max) {
	    		max = map.get(g).size();
	    		maxGuard = g;
	    	}
	    }
	    System.out.println(maxGuard);
	    for (Integer i : map.get(maxGuard)) {
	    	if (counter.containsKey(i)) {
	    		counter.put(i, counter.get(i)+1);
	    	}else counter.put(i, 1);
	    }
	    int maximum = 0;
	    int maxmin = 0;
	    for (Integer i : counter.keySet()) {
	    	if(counter.get(i) > maximum) {
	    		maximum = counter.get(i);
	    		maxmin = i;
	    	}
	    }
	    System.out.println(maxmin); 
	}
}
