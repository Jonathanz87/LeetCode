/*
	problem 42
	Given n non-negative integers representing an elevation map
	where the width of each bar is 1,
	compute how much water it is able to trap after raining.
	For example,
		Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class TrappingRainWater {
	public int trap(int[] height) {
		int totalArea = 0;
		int leftIndex = 0, rightIndex = height.length - 1;
		while (leftIndex < rightIndex && height[leftIndex] <= height[leftIndex + 1]) {
			leftIndex++;
		}

		while (rightIndex > leftIndex && height[rightIndex - 1] >= height[rightIndex]) {
			rightIndex--;
		}

		while (leftIndex < rightIndex) {
			int area = 0;
			if (height[leftIndex] < height[rightIndex]) {
				int i = leftIndex + 1;
				while (i < rightIndex && height[leftIndex] >= height[i]) {
					area += height[leftIndex] - height[i];
					i++;
				}

				leftIndex = i;
			} else {
				int i = rightIndex - 1;
				while (i > leftIndex && height[i] <= height[rightIndex]) {
					area += height[rightIndex] - height[i];
					i--;
				}

				rightIndex = i;
			}
			totalArea += area;
		}
		return totalArea;
	}

	/*
		solution
		set the most left as maxLeft and most right as maxRight
		if 		maxLeft < maxRight
		then	any bar that smaller than maxLeft traps water
				or any bar more higher than maxLeft does not trap water, 
				in this case, set it to new MaxLeft
		else	the same
						|
		|	w			|
		|	w			|
		|	|			|
		|	|			|
		|	|			|
	*/

	public static int trap2(int[] height) {
		if (height == null || height.length <= 0) return 0;
		int leftIndex = 0, rightIndex = height.length - 1;
		int maxLeft = height[leftIndex++], maxRight = height[rightIndex--];
		int water = 0;
		while (leftIndex <= rightIndex) {
			if (maxLeft < maxRight) {
				if (height[leftIndex] > maxLeft) {
					maxLeft = height[leftIndex];
				} else {
					water += maxLeft - height[leftIndex];
				}
				leftIndex++;
			} else {
				if (height[rightIndex] > maxRight) {
					maxRight = height[rightIndex];
				} else {
					water += maxRight - height[rightIndex];
				}
				rightIndex--;
			}
		}

		return water;
	}

}