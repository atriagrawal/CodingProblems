import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
	static PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	static PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            addToHeap(a[a_i]);
            System.out.println(getMedian());
        }
    }
    
    public static double getMedian() {
    	double median = 0.0;
    	if ((min.size()+max.size()) % 2 == 0) {
			median = (double)(min.peek()+max.peek())/2;
		} else if (min.size() > max.size()) {
			median = (double)min.peek();
		} else {
			median = (double)max.peek();
		}
    	return median;
    }
    
    private static void addToHeap(int currentNumber) {
    	PriorityQueue<Integer> targetHeap = max.size() >= min.size() ? min : max;
    	targetHeap.add(currentNumber);
    	balance();
    }
    
    private static void balance() {
    	if (!max.isEmpty() && !min.isEmpty() && min.peek() < max.peek()) {
    		int minimum = min.poll();
    		int maximum = max.poll();
    		min.add(maximum);
    		max.add(minimum);
    	}
    }
}
