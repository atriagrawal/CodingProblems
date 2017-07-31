import java.util.Scanner;

public class MaxGcd {

    static int maximumGcdAndSum(int[] A, int[] B) {
    	int[] factorA = new int[1000001];
    	int[] factorB = new int[1000001];
    	
    	int maxNum = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] > maxNum)
    			maxNum = A[i];
    		if (B[i] > maxNum)
    			maxNum = B[i];
        	findFactors(A[i], factorA);
        	findFactors(B[i], factorB);
        }
    	for (int i = maxNum; i > 0; i--) {
    		if (factorA[i] > 0 && factorB[i] > 0)
    			return factorA[i] + factorB[i];
    	}
        return -1;
    }
    
    static void findFactors(int num, int[] factor) {
        for (int i = 1; i <= Math.sqrt(num); i++) {
        	if (num % i == 0) {
        		if (num > factor[i])
        			factor[i] = num;
        		if (num > factor[num/i]) 
        			factor[num/i] = num;
        	}
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        //Set<Integer> A_set = new HashSet<Integer>();
        //Set<Integer> B_set = new HashSet<Integer>();
        
        /*for (int i = 0; i < A.length; i++) {
            A_set.add(A[i]);
            B_set.add(B[i]);
        }*/
        
        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }
}
