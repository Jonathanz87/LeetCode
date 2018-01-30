/*
	problem 744
	DescriptionHintsSubmissionsDiscussSolution
	Given a list of sorted characters letters containing only lowercase letters, 
	and given a target letter target, 
	find the smallest element in the list that is larger than the given target.
	Letters also wrap around. For example,
	if the target is target = 'z' and letters = ['a', 'b'], 
	the answer is 'a'.
	Examples:
		Input: letters = ["c", "f", "j"]
		target = "a"
		Output: "c"

		Input: letters = ["c", "f", "j"]
		target = "c"
		Output: "f"

		Input: letters = ["c", "f", "j"]
		target = "d"
		Output: "f"

		Input: letters = ["c", "f", "j"]
		target = "g"
		Output: "j"

		Input: letters = ["c", "f", "j"]
		target = "j"
		Output: "c"
		
		Input: letters = ["c", "f", "j"]
		target = "k"
		Output: "c"
	Note:
		letters has a length in range [2, 10000].
		letters consists of lowercase letters, and contains at least 2 unique letters.
		target is a lowercase letter.
*/

public class FindSmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(args[0].toCharArray(), args[1].charAt(0)));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int leftIndex = 0;
		int rightIndex = letters.length - 1;
		int result = 0;
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex + 1) >> 1;
			if (letters[mid] > target) {
				rightIndex = mid - 1;
			} else {
				leftIndex = mid;
			}
		}

		if (letters[leftIndex] > target) {
			return letters[leftIndex];
		}

		if (leftIndex != letters.length - 1) {
			result = leftIndex + 1;
		}

		return letters[result];
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int leftIndex = 0;
		int rightIndex = letters.length - 1;
		while (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) >> 1;
			if (letters[mid] > target) {
				rightIndex = mid - 1;
			} else {
				leftIndex = mid;
			}
		}
	}
}