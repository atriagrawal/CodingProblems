public class TwoKeys {
    public int minSteps(int n) {
    	if (n == 1)
    		return 0;
    	return getNumOfOps(n, 1, 0, true, true);
    }
    
    public int getNumOfOps(int n, int As, int buffer, boolean copy, boolean paste) {
    	System.out.println("n:" + n + " - As:" + As + " - buf:" + buffer + " - cpy:" + copy + " - pst:" + paste);
    	if (n == 0) {
    		System.out.println("op:" + 0);
    		return 0; 
    	} else if (n < 0) {
    		System.out.println("op:" + -1);
    		return -1;
    	}
    	int operation = 0;
    	if (copy) {
    		operation++;
    		buffer++;
    	}
    	if (paste) {
    		operation++;
    		As += buffer;
    	}
    	int withCopy = getNumOfOps(n - As, As, buffer, true, true);
    	int withoutCopy = getNumOfOps(n - As, As, buffer, false, true);

    	//System.out.println("op:" + (operation + Math.min(withCopy, withoutCopy)));
    	if (withCopy == -1 && withoutCopy == -1) 
    		return -1;
    	else if (withCopy == -1)
    		return operation + withoutCopy;
    	else if (withoutCopy == -1)
    		return operation + withCopy;
    	else {
    		System.out.println("op:" + (operation + Math.min(withCopy, withoutCopy)));
    		return Math.min(withCopy, withoutCopy);
    	}
    }
    
    public static void main(String args[]) {
    	TwoKeys t = new TwoKeys();
    	
    	System.out.println(t.minSteps(5));
    }
}