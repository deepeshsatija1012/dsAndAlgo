package algos.others;

/*
Given some number of floors and some number of eggs, what is the minimum 
number of attempts it will take to find out from which floor egg will break.
*/
public class EggDroppingProblem {

	public static int minAttempts(int floor, int eggs) {
		int[][] mat = new int[eggs + 1][floor + 1];
		for (int i = 0; i <= floor; i++) {
			mat[1][i] = i;
		}
		for (int i = 2; i <= eggs; i++) {
			for (int j = 1; j <= floor; j++) {
				mat[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k <= j; k++) {
					//1 + max(if it breaks at k, if it doesn't break at k)
					int c = 1 + Math.max(mat[i-1][k-1], mat[i][j-k]);
					if(c<mat[i][j]) {
						mat[i][j] = c;
					}
				}

			}

		}
		return mat[eggs][floor];
	}
	public static void main(String[] args) {
		System.out.println(minAttempts(5, 2));
	}

}
