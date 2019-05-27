package algos.integers;

import java.util.Arrays;

public class MaximumSumSubarray {

	public static int[] maxSumSubarray(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
		int start = 0, end = 0, s = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}

			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}
		}

		return Arrays.copyOfRange(arr, start, end);
	}

	public static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumSubarray(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 })));
	}

}
