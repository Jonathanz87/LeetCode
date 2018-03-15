/*
  problem 565
	A zero-indexed array A of length N contains all integers from 0 to N-1.
	Find and return the longest length of set S, where S[i] = {A[i],
	A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
	Suppose the first element in S starts with the selection of element A[i] of index = i,
	the next element in S should be A[A[i]], and then A[A[A[i]]]…
	By that analogy, we stop adding right before a duplicate element occurs in S.
	Example 1:
		Input: A = [5,4,0,3,1,6,2]
		Output: 4
		Explanation:
		A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
		One of the longest S[K]:
		S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
	Note:
		N is an integer within the range [1, 20,000].
		The elements of A are all distinct.
		Each element of A is an integer within the range [0, N-1].
*/

/*
	solution
	the key to solve this problem is that,
	all integers from 0 to n - 1 will be appeared in the size n array
	which means every integer will be appear one time
	since each number will only point to one integer
	for n nodes with n paths, and each node point to one non none node
	therefore, the nodes will be a combination of one or more loop.
	any node in the array will be appeared in exactly one loop
	so, if we traverse all the loops one time,
	we will also traverse all the nodes in the array exactly on time
*/

public class ArrayNesting {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(arrayNesting(nums));
	}

	public static int arrayNesting(int[] nums) {
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			int ct = 0;
			int n = i;
			while (nums[n] >= 0) {
				int temp = nums[n];
				nums[n] = -1;
				n = temp;
				ct++;
			}
			maxCount = Math.max(ct, maxCount);
		}
		return maxCount;
	}
}
