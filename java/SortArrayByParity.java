/*
    problem 905
    Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
    You may return any answer array that satisfies this condition.
    Example 1:
        Input: [3,1,2,4]
        Output: [2,4,3,1]
        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
    Note:
        1 <= A.length <= 5000
        0 <= A[i] <= 5000
*/

public class SortArrayByParity {
	public static void main(String[] args) {
		int[] nums = new int[args.length];

		for (int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}

		for (int n : sortArrayByParity2(nums)) {
			System.out.println(n);
		}
	}
	public static int[] sortArrayByParity(int[] A) {
		int evenIndex = 0;
		int oddIndex = A.length - 1;

		while (evenIndex < A.length && oddIndex >= 0 && evenIndex < oddIndex) {
			while (evenIndex < A.length && A[evenIndex] % 2 == 0) {
				evenIndex++;
			}

			while (oddIndex >= 0 && A[oddIndex] % 2 == 1) {
				oddIndex--;
			}

			if (evenIndex < A.length && oddIndex >= 0 && evenIndex < oddIndex) {
				A[evenIndex] = A[evenIndex] ^ A[oddIndex];
				A[oddIndex] = A[evenIndex] ^ A[oddIndex];
				A[evenIndex] = A[evenIndex] ^ A[oddIndex];
			}
		}

		return A;
	}

	public static int[] sortArrayByParity2(int[] A) {
		int[] result = new int[A.length];

		int left = 0, right = A.length - 1;

		for (int n : A) {
			if (n % 2 == 0) {
				result[left++] = n;
			} else {
				result[right--] = n;
			}
		}

		return result;
	}
}
