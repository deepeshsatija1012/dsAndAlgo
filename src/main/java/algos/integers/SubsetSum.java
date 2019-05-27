package algos.integers;

import java.util.Arrays;

import algos.utils.PrettyPrinter;
import algos.utils.Printer;

public class SubsetSum {
	private static final Printer<Boolean> P = new Printer<Boolean>() {
		@Override
		public String print(Boolean obj) {
			return obj.equals(Boolean.FALSE)?"F":"T";
		}
	};
	public static boolean sumToK(int[] input, int total) {
		Boolean[][] T = new Boolean[input.length+1][total+1];
		for(int i=0;i<T.length;i++) {
			Arrays.fill(T[i], Boolean.FALSE);
		}
		System.out.println(PrettyPrinter.print(T, P));
		for(int i=0;i<=input.length;i++) {
			T[i][0] = Boolean.TRUE;
		}
		
		
		for(int i=1;i<=input.length;i++) {
			for(int j=1;j<=total;j++) {
				if(j-input[i-1]>=0 ) {
					T[i][j] = T[i-1][j] || T[i-1][j-input[i-1]];
				}else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		System.out.println(PrettyPrinter.print(T, P));
		return T[input.length][total];
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2, 3, 7, 8, 10};
		System.out.println(sumToK(arr, 11));
		System.out.println(sumToK(arr, 14));
	}
}
