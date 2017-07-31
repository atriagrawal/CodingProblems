import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> s = new Stack<Character>();
        HashSet<Character> openBrackets = new HashSet<Character>();
        openBrackets.add('(');
        openBrackets.add('[');
        openBrackets.add('{');

        HashSet<Character> closedBrackets = new HashSet<Character>();
        closedBrackets.add(')');
        closedBrackets.add(']');
        closedBrackets.add('}');
        
        for (int i = 0; i < expression.length(); i++) {
            if (openBrackets.contains(expression.charAt(i))) {
                s.push(expression.charAt(i));
            } else if (closedBrackets.contains(expression.charAt(i))) {
                if (s.empty()) return false;
                Character c = s.pop();
                switch (c) {
                    case '{': 
                        if (expression.charAt(i) != '}') return false;
                        break;
                    case '[': 
                        if (expression.charAt(i) != ']') return false;
                        break;
                    case '(': 
                        if (expression.charAt(i) != ')') return false;   
                        break;
                    default:
                        return false;
                }
            }
        }
        if (s.empty())
        	return true;
        else 
        	return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
