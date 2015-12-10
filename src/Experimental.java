import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 import java.util.Map.Entry;
import java.util.Scanner;


  public class Experimental {

	  public static void main(String[] args) {
		    try {
		        Scanner input = new Scanner(System.in);
		        String regex = "+[\\w]+";

		        System.out.println("word (hit enter to stop): ");
		        String word = input.nextLine();

		        while(word.length() != 0){
		            if(word.matches(regex)){
		            System.out.println("match\n");
		            }
		            else{
		                System.out.println("no match\n");
		            }
		            System.out.println("word (hit enter to stop): ");
		            word = input.nextLine();
		        }
		        System.out.println("Good Bye");

		       } catch (Exception e) {

		      }

		  }
}