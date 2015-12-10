/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//System.setIn(new FileInputStream("non_decreasing_input.txt"));
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long a[] = new long[100000];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextLong();
            }
            
            long noOfSub = n;
            int start = 0;
            int end = 1;
            
            int k = 1;
            while (end < n) {
                k = 1;
                //System.out.println("Start="+start+", end="+(end)+", noOfSub="+noOfSub);
                while (end < n && a[end] >= a[end-1]) {
                    //System.out.println("Start="+start+", end="+(end)+", noOfSub="+noOfSub);
                    noOfSub += k;
                    k++;
                    end++;
                }
                start = end;
                end += 1;
                //System.out.println("Start="+start+", end="+(end)+", noOfSub="+noOfSub);
            }
            System.out.println(noOfSub);
        } 
	}
}  
