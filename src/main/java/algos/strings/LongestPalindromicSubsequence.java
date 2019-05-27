package algos.strings;

public class LongestPalindromicSubsequence {

	public static int longestPalindromicSubsequence(String s) {
		int[][] mat = new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			mat[i][i] = 1;
		}
		
		for(int i=0;i<s.length()-1;i++) {
			int j = i+1;
			if(s.charAt(i)==s.charAt(j)) {
				mat[i][j] = 2;
			}
		}
		
		for(int l = 3;l<=s.length(); l++) {
			for(int i=0;i<s.length()-l+1;i++) {
				int j = i+l-1;
				if(s.charAt(i)==s.charAt(j)) {
					mat[i][j] = mat[i+1][j-1] + 2;
				}else {
					mat[i][j] = Math.max(mat[i+1][j], mat[i][j-1]);
				}
			}
		}
		return mat[0][s.length()-1];
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubsequence("agbdba"));
	}
}
