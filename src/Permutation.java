public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute("abc".toCharArray(), 0);
	}

	public static void permute(char[] s, int k) {
		if (k == s.length - 1)
			System.out.println(s);
		for (int i = k; i < s.length; i++){
			char temp = s[i];
			s[i] = s[k];
			s[k] = temp;
			permute(s, k+1);
			temp = s[i];
			s[i] = s[k];
			s[k] = temp;
		}
	}
}
