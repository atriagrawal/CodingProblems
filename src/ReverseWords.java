
public class ReverseWords {
	public static void main(String args[]) {
		String s = "This is a test";
		reverse(s);
	}
	
	private static void reverse(String s) {
		if(s == null) return;
		String words[] = s.split(" ", 2);
		if (words.length < 2) reverse(null);
		else reverse(words[1]);
		System.out.print(words[0] + " ");
	}
}
