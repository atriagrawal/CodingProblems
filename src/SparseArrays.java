import java.util.Scanner;

public class SparseArrays {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        long arr[] = new long[m];
        long max = 0;
        for(int operations=0; operations < m; operations++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            arr[a] += k;
            arr[b+1] -= k;
        }
        
	}
}
