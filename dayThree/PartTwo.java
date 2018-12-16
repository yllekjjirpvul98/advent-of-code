package dayThree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.awt.Point;

public class PartTwo {
	
	
	public static void main(String[] args) throws IOException {
		HashMap<Point, Integer> map = new HashMap<Point, Integer>();
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayThree/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    
	    while ((line=in.readLine()) != null) {
	    	String[] s = line.split(" ");
	        String[] leftCorner = s[2].split(",");
	        String[] area = s[3].split("x");
	        //Assume coordinates start from (0,0)
	        for (int x = 0; x < Integer.parseInt(area[0]); x++) {
	        	for (int y = 0; y < Integer.parseInt(area[1]); y++) {
	        		Point p = new Point (Integer.parseInt(leftCorner[0])+ x, Integer.parseInt(leftCorner[1].substring(0, leftCorner[1].length()-1)) + y);
	        	    if (map.containsKey(p)) {
	        	    	map.put(p, map.get(p)+1);
	        	    }else {
	        	    	map.put(p, 1);
	        	    }
	        	}
	        }
	    }
	    inputStream = new FileInputStream("../advent_of_code/src/dayThree/input.txt");
	    reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    in = new BufferedReader(reader);
	    while ((line=in.readLine()) != null) {
	    	String[] s = line.split(" ");
	        String[] leftCorner = s[2].split(",");
	        String[] area = s[3].split("x");
	        boolean overlap = false;
	        //Assume coordinates start from (0,0)
	        for (int x = 0; x < Integer.parseInt(area[0]); x++) {
	        	for (int y = 0; y < Integer.parseInt(area[1]); y++) {
	        		Point p = new Point (Integer.parseInt(leftCorner[0])+ x, Integer.parseInt(leftCorner[1].substring(0, leftCorner[1].length()-1)) + y);
	        	    if (map.get(p) > 1) {
	        	    	overlap = true;
	        	    	break;
	        	    }else continue;
	        	}
	        	if (overlap) {
	        		break;
	        	}
	        }if (!overlap) {
	        	System.out.println(s[0]);
	        }
	    }
	    
	    
	    
	}
}
