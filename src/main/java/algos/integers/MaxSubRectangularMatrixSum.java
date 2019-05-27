package algos.integers;

public class MaxSubRectangularMatrixSum {
	
	public static int[] kadane(int[] arr) {
		int[] result = new int[] {Integer.MIN_VALUE, 0, -1};
		int currentSum = 0, start = 0;
		int maxElement = Integer.MIN_VALUE, maxIndex = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>maxElement) {
				maxElement = arr[i];
				maxIndex = i;
			}
			currentSum+= arr[i];
			if(currentSum<0) {
				currentSum = 0;
				start = i+1;
			}else if(currentSum>result[0]) {
				result[0] = currentSum;
				result[1] = start;
				result[2] = i;
			}
		}
		
		if(result[2]==-1) {
			result[0] = maxElement;
			result[1] = result[2] = maxIndex;
		}
		
		return result;
	}

}
