/*
	problem 338
	Given a non negative integer number num.
	For every numbers i in the range 0 ≤ i ≤ num 
	calculate the number of 1's in their binary representation 
	and return them as an array.
	Example:
	For num = 5 you should return [0,1,1,2,1,2].
	Follow up:
	It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
	But can you do it in linear time O(n) /possibly in a single pass?
	Space complexity should be O(n).
	Can you do it like a boss? Do it without using any builtin function like 
	__builtin_popcount in c++ or in any other language.
*/

public class CountingBits{
	public static void main(String[] args){
		int[] ones = countBits(5);
		for(int i = 0, len = ones.length; i < len; i++){
			System.out.println(ones[i]);
		}
	}

	public static int[] countBits(int num) {
		int[] ones = new int[num + 1];
		int digitMax = 1;

		for(int i = 1, j = 0; i <= num; i++){
			ones[i] = ones[j++] + 1;
			if(j >= digitMax){
				digitMax *= 2;
				j = 0;
			}
		}
		return ones;
	}

	public static int[] countBits2(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++)
			ans[i] = ans[i >> 1] + (i & 1);
		return ans;
	}
}