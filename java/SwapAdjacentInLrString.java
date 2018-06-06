public class SwapAdjacentInLrString {
	public static void main(String[] args) {
		System.out.println(canTransform(args[0], args[1]));
	}
	public static boolean canTransform(String start, String end) {
		if (start.length() != end.length()) return false;
		int l = 0, r = 0;

		for (int i = 0, size = start.length(); i < size; i++) {
			if (start.charAt(i) == 'R') r++;
			else if (start.charAt(i) == 'L') l--;
			if (end.charAt(i) == 'L') l++;
			else if (end.charAt(i) == 'R') r--;

			if (r < 0 || l < 0 || (r > 0 && l > 0)) return false;
		}

		return l == 0 && r == 0;
	}
}