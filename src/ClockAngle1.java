
/* package codechef; // don't place package name! */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* Name of the class has to be "Main" only if the class is public. */
class ClockAngle1 {
	private static Map<Double, ArrayList<String>> cachedAngleMapping = new HashMap<Double, ArrayList<String>>();
	private static List<Double> sortedAngles= new ArrayList<Double>();
	
	public static void main(String[] args) throws IOException {
		createMappingOfAngleAndTime();
		//System.setIn(new FileInputStream("clock_angle1.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int t = Integer.parseInt(br.readLine().trim());
		int t = sc.nextInt();
		// 1 ≤ T ≤ 100000
		// 0 ≤ A ≤ 180
		//long startTime = System.nanoTime();
		PrintWriter writer = new PrintWriter(System.out);
		
		if (t < 1 || t > 100000)
			return;
		DecimalFormat df = new DecimalFormat("#.####");
		//while((rawAngle=br.readLine())!=null) {
		for (int i=0; i < t; i++) {
			// System.out.println("no of test cases: " + t + ", Current=" + i);
			//if (rawAngle == null) return;
			//double n = Double.parseDouble(rawAngle.trim());
			double n = sc.nextDouble();
			if (n < 0 || n > 180)
				return;
			if (n == 180) {
				writer.println("06:00");
				continue;
			}
			if (!isValidAngle(n)) continue;
			List<String> times = cachedAngleMapping.get(Double.valueOf(df.format(n)));
			Double error = 0.0083;
			if(times != null) {
				for (String time : times) {
					if (time != null)
						writer.println(time);
				}
			} else {
				Double upperAngle = Double.valueOf(df.format(n + error));
				Double lowerAngle = Double.valueOf(df.format(n - error));
				Set<Double> angles = cachedAngleMapping.keySet();
				for (Double angle : angles) {
					times = null;
					//System.out.println(angle + ", " + upperAngle + ", " + lowerAngle);
					if (angle <= upperAngle && angle >= lowerAngle)
						times = cachedAngleMapping.get(Double.valueOf(angle));
					
					if(times != null) {
						for (String time : times) {
							if (time != null)
								writer.println(time);
						}
						break;
					}
				}
			}
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

	public static double computeAngle(int hour, int min) {
		double computedAngle = 0.5 * ((60D * hour) - (11D * min));
		computedAngle = Math.abs(computedAngle);
		// System.out.println("Before:: " + hour+":"+min+" = "+ computedAngle);
		if (computedAngle > 180)
			computedAngle = 360D - computedAngle;
	    //System.out.println("After:: " + hour+":"+min+" = "+ computedAngle);
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
	
	public static void createMappingOfAngleAndTime() {
		DecimalFormat df = new DecimalFormat("#.####");
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 60; k++) {
					Double computedAngle = computeAngle(j, k);
					computedAngle = Double.valueOf(df.format(computedAngle));
					//System.out.print(computedAngle + ", ");
					ArrayList<String> times = cachedAngleMapping.get(computedAngle);
					if(times == null) {
						times = new ArrayList<String>();
					}
					String time = "";
					if (j < 10)
						time += "0" + j;
					else
						time += j;
					time += ":";
					if (k < 10)
						time += "0" + k;
					else
						time += k;
					times.add(time);
					times.add(transpose(j, k));
					//System.out.println(time + ", " + transpose(j, k));
					cachedAngleMapping.put(computedAngle, times);
					sortedAngles.add(computedAngle);
				 
				//writer.println(j+":"+k+" = "+ computedAngle);
			}
		}
	}
	
	public static Boolean isValidAngle(Double angle) {
		Integer intAngleValue = angle.intValue();
		Double point5AngleValue = intAngleValue + 0.5D;
		Double error = 0.0083D;
		
		if (angle == intAngleValue.doubleValue()) {
			return true;
		} else if (angle <= (intAngleValue.doubleValue() + error)) {
			return true;
		} else if (angle >= (point5AngleValue - error) && angle <= (point5AngleValue + error)) {
			return true;
		} else if (angle >= (intAngleValue.doubleValue() + 1D) - error) {
			return true;
		} else {
			return false;
		}
	}
}