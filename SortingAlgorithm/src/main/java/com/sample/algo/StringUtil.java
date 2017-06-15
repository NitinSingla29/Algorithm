
public class StringUtil {

	public static boolean isSubsequence(String input, String longString) {
		int indextToMatch = 0;
		for (int i = 0; i < longString.length(); i++) {
			if(longString.charAt(i) == input.charAt(indextToMatch)) {
				indextToMatch ++;
				if(indextToMatch == input.length()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("AXY", "ADDXBBBBY"));

		System.out.println(isSubsequence("AXY", "ADDXB"));

		System.out.println(isSubsequence("gksrek", "geeksforgeeks"));
	}

}
