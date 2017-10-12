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

        while(rightIndex > leftIndex && height[rightIndex - 1] >= height[rightIndex]) {
            rightIndex--;
        }

        while(leftIndex < rightIndex) {
            int area = 0;
            if(height[leftIndex] < height[rightIndex]) {
                int i = leftIndex + 1;
                while(i < rightIndex && height[leftIndex] >= height[i]) {
                    area += height[leftIndex] - height[i];
                    i++;
                }

                leftIndex = i;
            } else {
                int i = rightIndex - 1;
                while(i > leftIndex && height[i] <= height[rightIndex]) {
                    area += height[rightIndex] - height[i];
                    i--;
                }

                rightIndex = i;
            }
            totalArea += area;
        }
        return totalArea;
    }
}