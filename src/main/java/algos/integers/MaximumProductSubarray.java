package algos.integers;

public class MaximumProductSubarray {
	
	public static int maxProductSumSubarray(int[] arr) {
		int maxSoFar = 1, maxEndingHere = 1, minEndingHere = 1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				maxEndingHere = maxEndingHere*arr[i];
				minEndingHere = Math.min(minEndingHere*arr[i], 1);
			}else if(arr[i]==0) {
				minEndingHere = 1;
				maxEndingHere = 1;
			}else /*if(arr[i]<0)*/ {
				/* If element is negative. This is tricky 
	               max_ending_here can either be 1 or positive. 
	               min_ending_here can either be 1 or negative. 
	               next min_ending_here will always be prev. 
	               max_ending_here * arr[i] 
	               next max_ending_here will be 1 if prev 
	               min_ending_here is 1, otherwise 
	               next max_ending_here will be  
	                           prev min_ending_here * arr[i] */
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere* arr[i], 1);
				minEndingHere = temp * arr[i];
			}
			
			if(maxSoFar<maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		System.out.println(maxProductSumSubarray(new int[] {1, -2, -3, 0, 7, -8, -2}));
	}
}
