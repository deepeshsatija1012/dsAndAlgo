package algos.integers;

import java.util.Arrays;

public class FloorAndCeiling {
	
	public static int ceiling(int[] arr, int x) {
		if(arr==null) {
			return -1;
		}
		if(arr.length==0) {
			return -1;
		}
		
		int low = 0, high = arr.length-1;
		while(true) {
			if(x<=arr[low]) {
				return low;
			}
			
			if(x>arr[high]) {
				return -1;
			}
			
			int mid = low + (high-low)/2;
			
			if(arr[mid]==x) {
				return mid;
			} else if (x>arr[mid]) {
				if(mid+1<=high && x<=arr[mid+1]) {
					return mid+1;
				}else {
					low = mid+1;
				}
			} else {
				if(mid-1>=low && x> arr[mid-1]) {
					return mid-1;
				}else {
					high = mid-1;
				}
			}
		}
	}
	
	public static int floor(int[] arr, int x) {
		if(arr==null) {
			return -1;
		}
		if(arr.length==0) {
			return -1;
		}
		
		int low = 0, high = arr.length-1;
		while(true) {
			if(x<arr[low]) {
				return -1;
			}
			
			if(x>=arr[high]) {
				return high;
			}
			
			int mid = low + (high-low)/2;
			
			if(arr[mid]==x) {
				return mid;
			} else if (x<arr[mid]) {
				if(mid-1>=low && x>arr[mid-1]) {
					return mid-1;
				}else {
					high = mid-1;
				}
			} else {
				if(mid+1<=high && x <arr[mid+1]) {
					return mid;
				}else {
					low = mid+1;
				}
			}
		}
	}

	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 4, 5, 6, 10, 20};
		printCeil(arr, 3);
		printCeil(arr, 11);
		printCeil(arr, 30);
		printCeil(arr, 10);
		arr = new int[] {1};
		printCeil(arr, 1);
		printCeil(arr, 0);
		printCeil(arr, 10);
		arr = new int[] {};
		printCeil(arr, 0);
		
		arr = new int[] {1, 2, 4, 5, 6, 10, 20};
		printfloor(arr, 3);
		printfloor(arr, 11);
		printfloor(arr, 30);
		printfloor(arr, 10);
		arr = new int[] {1};
		printfloor(arr, 1);
		printfloor(arr, 0);
		printfloor(arr, 10);
		arr = new int[] {};
		printfloor(arr, 0);
		
	}
	
	public static void printCeil(int[] arr, int x) {
		int index = ceiling(arr, x);
		if(index==-1) {
			System.out.println("No Ceiling for "+ x + " in arr="+Arrays.toString(arr));
		}else {
			System.out.println("Ceiling is "+ arr[index] + " for "+ x + " in arr="+Arrays.toString(arr));
		}
	}
	
	public static void printfloor(int[] arr, int x) {
		int index = floor(arr, x);
		if(index==-1) {
			System.out.println("No Floor for "+ x + " in arr="+Arrays.toString(arr));
		}else {
			System.out.println("Floor is "+ arr[index] + " for "+ x + " in arr="+Arrays.toString(arr));
		}
	}
}
