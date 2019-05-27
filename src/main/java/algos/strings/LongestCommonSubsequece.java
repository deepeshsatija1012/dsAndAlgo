package algos.strings;

public class LongestCommonSubsequece {
	enum Pick {
		S1, S2, BOTH;
	}
	
	public static String longestCommonSubsequence(String s1, String s2) {
		int[][] lcs = new int[s1.length()][s2.length()];
		Pick[][] tracker = new Pick[s1.length()][s2.length()];
		
		// If last character match trim both chars and add 1
		// If last character don't match trim one at a time and find max
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					if(i==0 || j==0) 
						lcs[i][j] = 1;
					else 
						lcs[i][j] = lcs[i-1][j-1] + 1;
					
					tracker[i][j] = Pick.BOTH;
				}else {
					if(i>0 && j>0) {
						if(lcs[i-1][j]>=lcs[i][j-1]) {
							lcs[i][j] = lcs[i-1][j];
							tracker[i][j] = Pick.S2; // ditch S1 characters
						}else {
							lcs[i][j] = lcs[i][j-1];
							tracker[i][j] = Pick.S1; // ditch S2 characters
						}
					}else {
						if(j>0 && i==0) {
							//first row can't trim S1
							lcs[i][j] = lcs[i][j-1];
							tracker[i][j] = Pick.S1;
						}else if(i>0 && j==0) {
							//first column can't trim S2
							lcs[i][j] = lcs[i-1][j];
							tracker[i][j] = Pick.S2;
						}
					}
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		int i=s1.length()-1, j=s2.length()-1;
		while(i>=0 && j>=0) {
			switch (tracker[i][j]) {
				case BOTH:
					builder.append(s1.charAt(i));
					i--;j--;
					break;
				case S1 :
					j--;
					break;
				case S2 : 
					i--;
					break;
				default:
					break;
			}
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ACBEA", "ADCA"));
	}

}
