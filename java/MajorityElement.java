/*
	problem 169
	Given an array of size n,
	find the majority element.
	The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and 
	the majority element always exist in the array.
*/
import java.util.Map;
import java.util.HashMap;

public class MajorityElement{
	static public void main(String[] args){
		int[] nums = {1,1,1,2};
		System.out.println(majorityElement(nums));
	}

	static public int majorityElement(int[] nums) {
		if(nums.length == 1) return nums[0];
		Map<Integer, Integer> majorityMap = new HashMap<Integer, Integer>();
		int majoritySize = nums.length / 2;
		for(int n : nums){
			if(majorityMap.containsKey(n)){
				int ct = majorityMap.get(n);
				if(++ct > majoritySize){
					return n;
				}
				majorityMap.put(n, ct);
			}else{
				majorityMap.put(n, 1);
			}
		}
		return 0;
	}

	static public int majorityElement2(int[] nums) {
		int majority = nums[0];
		int ct = 1;

		for(int i = 1; i < nums.length; i++){
			if(majority == nums[i]){
				ct++;
			}else if(ct == 0){
				majority = nums[i];
				ct++;
			}else{
				ct--;
			}
		}
		return majority;
	}
}