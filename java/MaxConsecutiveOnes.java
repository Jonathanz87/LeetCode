/*
	problem 485
	Given a binary array,
	find the maximum number of consecutive 1s in this array.
	Example 1:
		Input: [1,1,0,1,1,1]
		Output: 3
		Explanation: The first two digits or the last three digits are consecutive 1s.
		The maximum number of consecutive 1s is 3.
	Note:
	The input array will only contain 0 and 1.
	The length of input array is a positive integer and will not exceed 10,000
*/

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null) return 0;
        int maxOnes = 0;
        int lastZeroIndex = -1;
        int i = 0;

        for(int n : nums) {
            if(n == 0) {
                maxOnes = Math.max(i - lastZeroIndex - 1, maxOnes);
                lastZeroIndex = i;
            }
            i++;
        }
        maxOnes = Math.max(i - lastZeroIndex - 1, maxOnes);

        return maxOnes;
    }
}