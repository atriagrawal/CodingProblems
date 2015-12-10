
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* Name of the class has to be "Main" only if the class is public. */
class ClockAngle {
	//private static Map<String, Double> cachedAngleMapping = new HashMap<String, Double>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("clock_angle.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		// 1 ≤ T ≤ 100000
		// 0 ≤ A ≤ 180
		//long startTime = System.nanoTime();
		PrintWriter writer = new PrintWriter(System.out);
		
		if (t < 1 || t > 100000)
			return;
		DecimalFormat df = new DecimalFormat("#.####");
		for (int i = 0; i < t; i++) {
			// System.out.println("no of test cases: " + t + ", Current=" + i);
			Stack<String> s = new Stack<String>();
			double n = Double.parseDouble(br.readLine().trim());
			if (n < 0 || n > 180)
				return;
			if (n == 180) {
				writer.println("06:00");
				continue;
			}
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 30; k++) {
					//Double computedAngle = cachedAngleMapping.get(j+":"+k);
					//if (computedAngle == null) {
						double computedAngle = computeAngle(j, k);
						//cachedAngleMapping.put(j+":"+k, computedAngle);
					//} 
					//writer.println(j+":"+k+" = "+ computedAngle);

					//System.out.println("upper: " + upperAngle + ", lower: " + lowerAngle + ", computed: " + computedAngle);
					Double error = 0.0083;
					Double upperAngle = Double.valueOf(df.format(n + error));
					Double lowerAngle = Double.valueOf(df.format(n - error));
					if (computedAngle == n || (computedAngle < upperAngle && computedAngle > lowerAngle)) {
						if (j < 10)
							writer.print("0" + j);
						else
							writer.print(j);
						writer.print(":");
						if (k < 10)
							writer.print("0" + k);
						else
							writer.print(k);
						writer.println();
						String time = transpose(j, k);
						if (time != null)
							s.push(time);
						break;
					}
				}
			}
			while (!s.empty())
				writer.println(s.pop());
		}
		
		//long endTime = System.nanoTime();
		//long duration = (endTime - startTime) / 1000000; // divide by 1000000 to
															// get milliseconds.
		//writer.println("duration: " + duration);
		writer.flush();
		//sc.close();
	}

	public static double computeAngle(int hour, int min) {
		double computedAngle = 0.5 * ((60 * hour) - (11 * min));
		computedAngle = Math.abs(computedAngle);
		// System.out.println("Before:: " + hour+":"+min+" = "+ computedAngle);
		if (computedAngle > 180)
			computedAngle = 360D - computedAngle;
		// System.out.println("After:: " + hour+":"+min+" = "+ computedAngle);
		return computedAngle;
	}

	public static String transpose(int hour, int min) {
		int h = 12 - hour;
		if (hour == 0 && min == 0)
			return null;
		int m;
		if (min != 0) {
			h--;
			m = 60 - min;
		} else {
			m = min;
		}

		StringBuilder time = new StringBuilder();
		if (h < 10)
			time.append("0" + h);
		else
			time.append(h);
		time.append(":");
		if (m < 10)
			time.append("0" + m);
		else
			time.append(m);
		return time.toString();
	}
}