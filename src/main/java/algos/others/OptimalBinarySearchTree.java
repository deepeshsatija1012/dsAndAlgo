package algos.others;

/**
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1]
 * of frequency counts, where freq[i] is the number of searches to keys[i].
 * 
 * Construct a binary search tree of all keys such that the total cost of all
 * the searches is as small as possible.
 *
 */
public class OptimalBinarySearchTree {

	private static int getSum(int freq[], int i, int j) {
		int sum = 0;
		for (int x = i; x <= j; x++) {
			sum += freq[x];
		}
		return sum;
	}

	public static int minCostBST(int[] keys, int[] freq) {
		int[][] mat = new int[keys.length][keys.length];
		// For length 1 rooted at i
		for (int i = 0; i < keys.length; i++) {
			mat[i][i] = freq[i];
		}

		// for length 2.. N
		for (int len = 2; len <= keys.length; len++) {
			for (int i = 0; i < keys.length - len + 1; i++) {
				int j = i + len - 1;
				mat[i][j] = Integer.MAX_VALUE;
				int sum = getSum(freq, i, j);
				// Rooted a k
				for (int k = i; k <= j; k++) {
					int val = sum + (k - 1 < i ? 0 : mat[i][k - 1]) + (k + 1 > j ? 0 : mat[k + 1][j]);
					if (val < mat[i][j]) {
						mat[i][j] = val;
					}
				}
			}
		}

		return mat[0][keys.length - 1];
	}

	public static void main(String[] args) {
		int keys[] = { 10, 12, 20, 35, 46 };
		int freq[] = { 34, 8, 50, 21, 16 };
		System.out.println(minCostBST(keys, freq));
		keys = new int[]{ 10, 12, 20 };
		freq = new int[]{ 34, 8, 50 };
		System.out.println(minCostBST(keys, freq));
	}

}
