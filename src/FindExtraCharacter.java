//Given 2 strings, find the extra character
//String s1 = "abcdefggghabdbababababab";
//String s2 = "abcdefghabdbabababababg";
// The difference between the lengths of strings will always be 1

public class FindExtraCharacter {

	public static void main(String[] args) {
		char extraChar = extraChar("abababg", "ababab");
		System.out.print(extraChar);
	}

	public static char extraChar(String s1, String s2) {
		int[] arr = new int[255];
		int len = s1.length() > s2.length() ? s1.length() : s2.length();

		for (int i = 0; i < len - 1; i++) {
			int index1 = (int) s1.charAt(i);
			int index2 = (int) s2.charAt(i);

			arr[index1]++;
			arr[index2]++;
		}
		int index = s1.length() > s2.length() ? s1.charAt(len - 1) : s2.charAt(len - 1);
		arr[index]++;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] != 0)
				return (char)i;
		}
		return '\n';
	}

}
