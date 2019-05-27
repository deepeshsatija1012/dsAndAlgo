package algos.integers;

public class ZeroOneKnapsackProblem {
	
	public static int zeroOneKnapSackProblem(int[] vals, int[] wts, int w) {
		int[][] KSP = new int[vals.length+1][w+1];
		for(int i=0;i<=vals.length;i++) {
			for(int j=0;j<=w;j++) {
				if(i==0 || j==0) {
					KSP[i][j] = 0;
					continue;
				}
				
				if(j-wts[i-1]>=0) {
					KSP[i][j] = 
							Math.max(KSP[i-1][j], vals[i-1]+KSP[i-1][j-wts[i-1]]);
				}else {
					KSP[i][j] = KSP[i-1][j];
				}
			}
		}
		return KSP[vals.length][w];
	}

	public static void main(String[] args) {
		int vals[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wts[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        System.out.println(zeroOneKnapSackProblem(vals, wts, 30));
	}
	
}
