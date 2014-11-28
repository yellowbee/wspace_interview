package misc.arraynstring;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInAString {
	public static void main(String[] args) {
		String s = "hawaii";
		System.out.println(RemoveDuplicatesInAString.rmDup(s));
	}
	
	// remove duplicated characters in a string
	public static String rmDup(String s) {
	    char[] S = s.toCharArray();
	    Set<Character> set = new HashSet<Character>();
	    StringBuilder result = new StringBuilder();
	    
	    for (int i=0; i<S.length; i++) {
	        Character ch = new Character(S[i]);
	        if (!set.contains(ch)) {
	            result.append(S[i]);
	            set.add(ch);
	        }
	    }
	    
	    return result.toString();
	}
}
