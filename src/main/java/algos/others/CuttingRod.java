package algos.others;

/*
Given a rod of length and prices at which different length of this rod can sell, how do you cut this rod to maximize profit
https://github.com/mission-peace/inte...
https://github.com/mission-peace/inte...
*/
public class CuttingRod {
	public static int maxProfit(int lenOfRod, int[] lenCut, int[] profit) {
		int[][] mat = new int[lenCut.length+1][lenOfRod+1];
		for(int i=1;i<=lenCut.length;i++) {
			for(int j=1;j<=lenOfRod;j++) {
				if(j>=lenCut[i-1]) {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-lenCut[i-1]]+profit[i-1]);
				}else {
					mat[i][j] = mat[i-1][j];
				}
			}
		}
		return mat[lenCut.length][lenOfRod];
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(5, new int[] {1, 2, 3, 4}, new int[] {2, 5, 7, 8}));
	}
}
