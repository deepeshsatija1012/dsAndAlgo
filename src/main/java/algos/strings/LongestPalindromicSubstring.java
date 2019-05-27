package algos.strings;

public class LongestPalindromicSubstring {
	
	public static String longestPalindromicSubstringDP(String s) {
		boolean[][] lps = new boolean[s.length()][s.length()];
		int palindroneBeginIndex = -1;
		
		for(int i=0;i<s.length();i++) {
			lps[i][i] = true;
		}
		
		int maxLen = 1;
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				lps[i][i+1] = true;
				palindroneBeginIndex = i;
				maxLen = 2;
			}
		}
		for(int currLen = 3;currLen<=s.length();currLen++) {
			for(int i=0;i<s.length()-currLen+1;i++) {
				int j = i+currLen-1;
				if(s.charAt(i)==s.charAt(j) && lps[i+1][j-1]) {
					lps[i][j] = true;
					palindroneBeginIndex = i;
					maxLen = currLen;
				}
			}
			
		}
		
		return s.substring(palindroneBeginIndex, maxLen+palindroneBeginIndex);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstringDP("BANANA"));
		System.out.println(longestPalindromicSubstringDP("ABABABA"));
	}

}
