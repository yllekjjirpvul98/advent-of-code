package dayTwo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.ArrayList;

public class partTwo {
	
	public static String DifferByOne (String a, String b) {
		for (int i=0; i < a.length(); i++) {
			if (a.equals(b)) {
				return null;
			}
			if (i == 0) {
				String aSub = a.substring(1);
		        String bSub = b.substring(1);
		        if (aSub.equals(bSub)) {
		        	return aSub;
		        }
			}else if (i == a.length()-1) {
				String aSub = a.substring(0, a.length()-1);
				String bSub = b.substring(0, b.length()-1);
				if (aSub.equals(bSub)) {
					return aSub;
				}
			}else {
				String aSub1 = a.substring(0, i);
				String aSub2 = a.substring(i+1, a.length());
				String bSub1 = b.substring(0, i);
				String bSub2 = b.substring(i+1, b.length());
				if (aSub1.equals(bSub1) && aSub2.equals(bSub2)) {
					return aSub1.concat(aSub2);
				}
			}
		}return null;
	}
	
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream("../advent_of_code/src/dayTwo/input.txt");
	    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    ArrayList<String> list = new ArrayList<String>();
	    String line;
	    String result = null;
	    while ((line = in.readLine()) != null) {
	    	list.add(line);
	    }
	    for (int i = 0; i < list.size(); i++) {
	    	for (int j = 1; j < list.size(); j++) {
	    		String a = list.get(i);
	    		String b = list.get(j);
	    		if ((result = DifferByOne(a,b)) != null) {
	    			System.out.println(result);
	    			break;
	    		}else continue;
	    	}
	    	if (result != null) {
	    		break;
	    	}
	    }
	}

}
