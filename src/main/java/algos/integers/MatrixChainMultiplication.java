package algos.integers;

public class MatrixChainMultiplication {
	
	public static int minCostOfMultiplication(int[] rows, int[] cols) {
		int[][] mat = new int[rows.length][rows.length];
		for(int i=0;i<rows.length-1;i++) {
			mat[i][i+1] = rows[i]*cols[i]*cols[i+1];
		}
		
		for(int len = 3; len<=rows.length;len++) {
			for(int i=0;i<rows.length-len+1;i++) {
				int j = i+len-1;
				mat[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int t = mat[i][k] + 
							mat[k+1][j] +
							rows[i]*rows[k+1]*cols[j];
					if(t<mat[i][j]) {
						mat[i][j] = t;
					}
				}
			}
		}
		return mat[0][rows.length-1];
	}
	
	public static void main(String[] args) {
		int[] rows = new int[4], cols = new int[4];
		rows[0] = 2; cols[0] = 3;
		rows[1] = 3; cols[1] = 6;
		rows[2] = 6; cols[2] = 4;
		rows[3] = 4; cols[3] = 5;
		
		System.out.println(minCostOfMultiplication(rows, cols));
	}

}
