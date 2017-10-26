/*
	problem 18
	Given an array S of n integers, are there elements a, b, c, and d in S
	such that a + b + c + d = target?
	Find all unique quadruplets in the array which gives the sum of target.
	Note: The solution set must not contain duplicate quadruplets.
	For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
		A solution set is:
		[
			[-1,  0, 0, 1],
			[-2, -1, 1, 2],
			[-2,  0, 0, 2]
		]
*/

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0, iLen = nums.length - 3, jLen = iLen + 1, kLen = jLen + 1; i < iLen; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            target -= nums[i];

            for (int j = i + 1; j < jLen; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                target -= nums[j];

                int leftIndex = j + 1, rightIndex = nums.length - 1;

                while (leftIndex < rightIndex) {
                    if(leftIndex != j + 1 && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                        continue;
                    }
                    int sum = nums[leftIndex] + nums[rightIndex];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex]));
                        leftIndex++;
                        rightIndex--;
                    } else if(sum > target) {
                        rightIndex--;
                    } else {
                        leftIndex++;
                    }
                }

                target += nums[j];
            }

            target += nums[i];
        }

        return result;
    }
}