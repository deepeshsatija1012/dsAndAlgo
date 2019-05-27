package algos.integers;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
	private static class Node {
		int val;
		Node parent;
	}
	public static int[] longestIncreasngSubsequence(int[] arr) {
		Node[] sequence = new Node[arr.length+1];
		int length = 0;
		for(int i=0;i<arr.length;i++) {
			int low = 1 , high = length;
			Node n = new Node(); n.val  = arr[i];
			while(low<=high) {
				int mid = (int) Math.ceil((low+high)/2);
				if(sequence[mid].val < arr[i]) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
			
			int pos = low;
			n.parent = pos-1>=0?sequence[pos-1]:null;
			sequence[pos] = n;
			
			if(pos>length) {
				length = pos;
			}
			
		}
		
		int[] res = new int[length];
		Node l = sequence[length];
		int j = length-1;
		while(l!=null) {
			res[j] = l.val;
			l = l.parent;
			j--;
		}
		return res;
	}
	
	public static int longestIncreasngSubsequenceDP(int[] arr) {
		int[] temp = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			temp[i] = 1;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					temp[i] = Math.max(temp[i], temp[j]+1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<temp.length;i++) {
			if(temp[i]>max) {
				max = temp[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(longestIncreasngSubsequence(new int[] {3, 1, 5, 2, 6, 4, 9})));
		System.out.println(Arrays.toString(longestIncreasngSubsequence(new int[] {10,20,30,5,60,70})));
		System.out.println(longestIncreasngSubsequenceDP(new int[] {3, 1, 5, 2, 6, 4, 9}));
		System.out.println(longestIncreasngSubsequenceDP(new int[] {10,20,30,5,60,70}));
		System.out.println(longestIncreasngSubsequenceDP(new int[] {3, 4, -1, 0, 6, 2, 3}));
		System.out.println(Arrays.toString(longestIncreasngSubsequence(new int[] {3, 4, -1, 0, 6, 2, 3})));
	}

}
