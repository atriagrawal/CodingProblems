public class ReverseWordsInplace {

	public static void main(String[] args) {
		reverseWords(new StringBuilder("This is a test"));
	}

	public static void reverseWords(StringBuilder s) {
		StringBuilder str = new StringBuilder(s);
		int startWordIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' || str.length() - 1 == i) {
				int x = 0;
				int endWordIndex = str.charAt(i) == ' ' ? i - 1 : i;
				while (endWordIndex - x > startWordIndex + x) {
					char c1 = str.charAt(startWordIndex + x);
					char c2 = str.charAt(endWordIndex - x);
					str.setCharAt(startWordIndex + x, c2);
					str.setCharAt(endWordIndex - x, c1);
					x++;
				}
				startWordIndex = i + 1;
			}
		}
		System.out.println(str);
	}
}