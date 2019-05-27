package algos.integers;

public class WaysToFormCoinChange {

	public static int waysToFormChangeofK(int total, int[] coins) {
		int[][] mat = new int[coins.length + 1][total + 1];
		for (int i = 0; i <= coins.length; i++) {
			mat[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					mat[i][j] = mat[i - 1][j];
				} else {
					mat[i][j] = mat[i][j - coins[i - 1]] + mat[i - 1][j];
				}
			}
		}
		return mat[coins.length][total];
	}

	public static int numberOfSolutionsOnSpace(int total, int coins[]) {

		int temp[] = new int[total + 1];

		temp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= coins[i]) {
					temp[j] += temp[j - coins[i]];
				}
			}
		}
		return temp[total];
	}

	public static void main(String[] args) {
		System.out.println(waysToFormChangeofK(15, new int[] { 3, 4, 6, 7, 9 }));
		System.out.println(numberOfSolutionsOnSpace(15, new int[] { 3, 4, 6, 7, 9 }));

		System.out.println(waysToFormChangeofK(5, new int[] { 1, 2, 3 }));
	}

}
