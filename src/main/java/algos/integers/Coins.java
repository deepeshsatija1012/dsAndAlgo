package algos.integers;

public class Coins {
	
	public static int minCoinChange(int[] coins, int total) {
		int[] mat = new int[total+1];
		for(int i=1;i<=total;i++) {
			mat[i] = Integer.MAX_VALUE-1;
		}
		for(int i=0;i <coins.length ; i++) {
			for(int j=1;j<=total;j++) {
				if(j>=coins[i]) {
					if(mat[j-coins[i]]+1<mat[j]) {
						mat[j] = mat[j-coins[i]]+1;
					}
				}
			}
		}
		return mat[total];
	}
	
	public int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
    }

    private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

	public static void main(String[] args) {
		System.out.println(minCoinChange(new int[] {6, 5, 1, 8}, 11));
	}
}
