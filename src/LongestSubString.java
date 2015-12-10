
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/* Name of the class has to be "Main" only if the class is public. */

public class LongestSubString {

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("clock_angle1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		PrintWriter writer = new PrintWriter(System.out);

		if (t < 1 || t > 10)
			return;
		
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			String line = br.readLine().trim();
			String[] words = line.split(" ");
			String previousLongestSubString = null;
			for (int j = 0; j<n-1; j++) {
				//System.out.println(words[j]);
				String longestSubString = findLongestSubString(words[j], words[j+1]);
				//System.out.println(longestSubString);
				if (previousLongestSubString != null) {
					if (!longestSubString.equals(previousLongestSubString)) {
						previousLongestSubString = findLongestSubString(previousLongestSubString, longestSubString);
					}
				} else {
					previousLongestSubString = longestSubString;
				}
			}
			System.out.println(previousLongestSubString);
		}
	}

	private static String findLongestSubString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int arr[][] = new int[len1+1][len2+1];
		int largest = 0;
		int largestI = 0;
		
		for(int i = 1; i < len1+1; i++) {
			for(int j = 1; j < len2+1; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1;
					if (arr[i][j] > largest) {
						largest = arr[i][j];
						largestI = i-1;
					}
				}
			}
		}
		return s1.substring(largestI-(largest-1), largestI+1);
	}

}
