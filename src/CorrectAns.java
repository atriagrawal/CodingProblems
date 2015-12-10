
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CorrectAns {
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("correct_ans.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// 1 ≤ T ≤ 500
		// 1 ≤ N ≤ 1000
		// 0 ≤ Wi ≤ 109
		if (t < 1 || t > 500)
			return;
		for (int i = 0; i < t; i++) {
			// System.out.println("no of test cases: " + t + ", Current=" + i);
			char[] correctAns = new char[1000];
			char[] chefAns = new char[1000];
			long[] weights = new long[1001];

			int n = sc.nextInt();
			if (n < 1 || n > 1000)
				return;
			String temp = sc.next();
			for (int j = 0; j < n; j++) {
				correctAns[j] = temp.charAt(j);
			}
			temp = sc.next();
			for (int j = 0; j < n; j++) {
				chefAns[j] = temp.charAt(j);
			}
			for (int j = 0; j < n + 1; j++) {
				weights[j] = sc.nextLong();
				if (weights[j] > 1000000000 || weights[j] < 0)
					return;
			}
			// System.out.println("chefAns=" + chefAns.toString());

			int noOfCorrect = 0;
			for (int j = 0; j < n; j++) {
				if (chefAns[j] == correctAns[j]) {
					noOfCorrect++;
				}
			}
			// System.out.println("No of correct: " + noOfCorrect);
			long highestScore = weights[0];
			for (int j = 0; j < noOfCorrect + 1; j++) {
				if (highestScore < weights[j]) {
					highestScore = weights[j];
				}
			}
			if (noOfCorrect == n)
				System.out.println(weights[n]);
			else
				System.out.println(highestScore);
		}
		sc.close();
	}
}