import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static final Set<String> Dictionary = new HashSet<String>();

	public static void main(String[] args) {
		populateDictionary();
		String s = "testthisouthat";
		System.out.println(segment(s));
	}

	public static String segment(String s) {
		String segment = "";
		if (inDictionary(s))
			return s;
		for (int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if (inDictionary(prefix)) {
				segment = segment(s.substring(i, s.length()));
				if (segment != null) {
					return prefix + " " + segment;
				}
			}
		}
		return null;
	}

	public static boolean inDictionary(String s) {
		if (Dictionary.contains(s))
			return true;
		else
			return false;
	}

	public static void populateDictionary() {
		Dictionary.add("test");
		Dictionary.add("this");
		Dictionary.add("out");
		Dictionary.add("is");
		Dictionary.add("that");
		Dictionary.add("at");
		Dictionary.add("south");
		Dictionary.add("hat");
	}

}
