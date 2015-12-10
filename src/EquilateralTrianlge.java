
/* package codechef; // don't place package name! */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class EquilateralTriangle {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("equilateral.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// 1 ≤ T ≤ 100000
		// 0 ≤ A ≤ 180
		//long startTime = System.nanoTime();
		PrintWriter writer = new PrintWriter(System.out);
		
		if (t < 1 || t > 1000000)
			return;
		//while((rawAngle=br.readLine())!=null) {
		for (int i=0; i < t; i++) {
			// System.out.println("no of test cases: " + t + ", Current=" + i);
			
			int n = sc.nextInt();
			Integer a = 0;
			if (n <= 0)
				return;
			if (n%2 != 0) {
				a = n + 1;
			} else {
				a = n + 2;
			}
			writer.print(n+"->");
			Double aSqBy4 = Math.pow(a.doubleValue(), 2) / 4;
			Double bSq = Math.pow(n, 2);
			String flag = "NO";
			while (aSqBy4 < bSq) {
				if(a == n) {
					a += 2;
					continue;
				}
				if (isPerfectSq(bSq - aSqBy4)) {
					writer.println(a);
					flag = "YES";
					break;
				}
				a += 2;
				aSqBy4 = Math.pow(a.doubleValue(), 2) / 4;
			}
			writer.println(flag);
			writer.flush();
		}
		
		//long endTime = System.nanoTime();
		//long duration = (endTime - startTime) / 1000000; // divide by 1000000 to
															// get milliseconds.
		//writer.println("duration: " + duration);
		writer.flush();
		writer.close();
		sc.close();
	}
	
	public static boolean isPerfectSq(Double value) {
		Double sqrt = Math.sqrt(value);
		if (sqrt == Math.floor(sqrt)) {
			return true;
		}
		return false;
	}
	
}