package algos.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubstring {
	
	public static Set<String> longestCommonSubstring(String s1, String s2) {
		int[][] match = new int[s1.length()][s2.length()];
		int max = Integer.MIN_VALUE;
		Set<String> result = null;
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					if(i==0 || j==0) match[i][j] = 1;
					else match[i][j] = match[i-1][j-1]+1;
				}
				
				if(match[i][j]>max) {
					max = match[i][j];
					result = new HashSet<>();
				}
				result.add(s1.substring(i-max+1, i+1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("LCLC", "CLCL"));
	}

}
