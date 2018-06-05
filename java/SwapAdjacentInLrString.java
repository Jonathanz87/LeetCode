public class SwapAdjacentInLrString {
	public static void main(String[] args) {
		System.out.println(canTransform(args[0], args[1]));
	}
	public static boolean canTransform(String start, String end) {
		if (start.length() != end.length()) return false;
		int ct = 0, size = start.length();
		int sIndex = 0, eIndex = 0;

		while (sIndex < size && eIndex < size) {
			if (start.charAt(sIndex) == 'L') {
				sIndex++;
				if (ct > 0) {
					ct--;
					continue;
				}
				if (end.charAt(eIndex) == 'L') {
					eIndex++;
					continue;
				}
				System.out.println("1 " + sIndex + " - " + eIndex);
				return false;
			}
			if (end.charAt(eIndex) == 'R') {
				eIndex++;
				if (ct < 0) {
					ct++;
					continue;
				}
				if (start.charAt(sIndex) == 'R') {
					sIndex++;
					continue;
				}
								System.out.println("2 " + sIndex + " - " + eIndex);
				return false;
			}

			if (start.charAt(sIndex) == 'R' && end.charAt(eIndex) == 'L') {
								System.out.println("3 " + sIndex + " - " + eIndex);
				return false;
			}

			if (start.charAt(sIndex) == 'R') {
				ct--;
				sIndex++;
				continue;
			}
			if (end.charAt(eIndex) == 'L') {
				ct++;
				eIndex++;
				continue;
			}
			sIndex++;
			eIndex++;
		}

		while (sIndex < size) {
			if (start.charAt(sIndex) != 'L' || ct <= 0) {
								System.out.println("4 " + sIndex + " - " + eIndex);
				return false;
			}
			sIndex++;
			ct --;
		}
		while (eIndex < size) {
			if (end.charAt(eIndex) != 'R' || ct >= 0) {
								System.out.println("5 " + sIndex + " - " + eIndex);
				return false;
			}
			eIndex++;
			ct ++;
		}
		return true;
	}
}