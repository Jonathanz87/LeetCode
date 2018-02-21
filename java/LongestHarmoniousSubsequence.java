/*
	problem 594
	We define a harmonious array is an array where the difference between 
	its maximum value and its minimum value is exactly 1.
	Now, given an integer array, 
	you need to find the length of its longest harmonious subsequence among all its possible subsequences.
	Example 1:
		Input: [1,3,2,2,5,2,3,7]
		Output: 5
		Explanation: The longest harmonious subsequence is [3,2,2,2,3].
	Note: The length of the input array will not exceed 20,000.
*/

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {
	public static void main(String[] args){
		int[] nums = new int[args.length];
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println(findLHS2(nums));
	}
    public static int findLHS(int[] nums) {
    	if(nums == null) return 0;
    	int longest = 0;
    	Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums){
        	int ct = 1;
        	if(numMap.containsKey(num)){
        		ct += numMap.get(num);
        	}

        	numMap.put(num, ct);

        	longest = Math.max(Math.max(numMap.getOrDefault(num - 1, -ct), numMap.getOrDefault(num + 1, -ct)) + ct,longest);
        }

        return longest;
    }

    public static int findLHS2(int[] nums) {
    	if(nums == null || nums.length <= 1){
    		return 0;
    	}
    	Arrays.sort(nums);
    	int longest = 0;
    	int preCt = Integer.MIN_VALUE;
    	int curCt = 1;

    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] == nums[i - 1]){
    			curCt++;
    		}else{
 				longest = Math.max(preCt + curCt, longest);
    			preCt = nums[i] - nums[i - 1] == 1 ? curCt : Integer.MIN_VALUE;
    			curCt = 1;
    		}
    	}

		return Math.max(preCt + curCt, longest);
    }
}