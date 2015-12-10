import java.util.*;
import java.lang.*;

public class temp {
	private static int month, year, day, sumOfDigits;
	private static boolean isLeapYear = year % 4 == 0 || year % 400 == 0 || year == 2000;

	private static void DOB() {
		/*int filler1 = 0, filler2 = 0;
		Scanner console = new Scanner(System.in);
		System.out.print("Enter birth date (mm/dd/yyyy):");
		int monthB = console.nextInt();
		char symbol1 = console.next().charAt(0);
		int dayB = console.nextInt();
		char symbol2 = console.next().charAt(0);
		int yearB = console.nextInt();
		while (yearB < 1980 || yearB > 2280) {
			System.out.printf("Bad year: %d\n", year);
			System.out.print("Enter birth date(mm/dd/yyyy):");
			monthB = console.nextInt();
			symbol1 = console.next().charAt(0);
			dayB = console.nextInt();
			symbol2 = console.next().charAt(0);
			yearB = console.nextInt();
		}*/
		Scanner console = new Scanner(System.in);
		console.useDelimiter(" /");
		int i = console.nextInt();
		System.out.println(i);
		//String arr[] = line.split("/");
		//for(String s : arr)
		//	System.out.println(Integer.parseInt(s));
	}

	private static void Confirm() {
		/*if (month > 12 || month < 1) {
			System.out.printf("Bad Month: %d", month);
		}
		if ((month == 2 && day == 29) && !isLeapYear) {
		} else if (day > 31 || day < 0) {
			System.out.printf("Bad day:%d", day);
		} else {
		}*/
	}

	public static void main(String[] args) {
		DOB();
		Confirm();
	}
}
