package algos.strings;

public class MinimumEditDistance {
	
	public static int minimumEditDistance(String from, String to) {
		int[][] arr = new int[to.length()+1][from.length()+1];
		for(int i=0;i<=to.length();i++) {
			arr[i][0] = i;
		}
		
		for(int i=0;i<=from.length();i++) {
			arr[0][i] = i;
		}
		
		for(int i=1;i<=to.length();i++) {
			for(int j=1;j<=from.length();j++) {
				if(to.charAt(i-1)==from.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1];
				}else {
					arr[i][j] = 1 +Math.min(Math.min(arr[i-1][j], arr[i-1][j-1]), arr[i][j-1]); 
				}
			}
		}
		
		int i = arr.length - 1;
        int j = arr[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (to.charAt(i-1) == from.charAt(j-1)) {
                i = i-1;
                j = j-1;
            } else if (arr[i][j] == arr[i-1][j-1] + 1){
                System.out.println("Edit " + from.charAt(j-1) + " in 'from' to " + to.charAt(i-1) + " in 'to'");
                i = i-1;
                j = j-1;
            } else if (arr[i][j] == arr[i-1][j] + 1) {
                System.out.println("Delete in 'to' " + to.charAt(i-1));
                i = i-1;
            } else if (arr[i][j] == arr[i][j-1] + 1){
                System.out.println("Delete in 'from' " + from.charAt(j-1));
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
		
		return arr[to.length()][from.length()];
		
	}
	
	public static void main(String[] args) {
		System.out.println(minimumEditDistance("abcdef", "azced"));
	}

}
