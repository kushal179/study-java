package study;

public class StringPrac {

	/**
	 * @param args
	 */
	static boolean isReverse(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int s1Length = s1.length() - 1;
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) != s1.charAt(s1Length))
				return false;
			s1Length--;
		}
		return true;
	}

	static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length() && s1.length() == 0)
			return false;
		String s1s1 = s1 + s1;
		return s1s1.indexOf(s2) != -1;
	}

	public static void main(String[] args) {
		String s1 = "abcdefgh";
		String s2 = "hgfedcba";

		System.out.println("S2 is Reverse of S1? "
				+ StringPrac.isReverse(s1, s2));
		
		s1 = "waterbottle";
		s2 = "terbottlewa";

		System.out.println("S2 is Rotation of S1? "
				+ StringPrac.isRotation(s1, s2));

	}

}
