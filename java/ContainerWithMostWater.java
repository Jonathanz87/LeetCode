/*	Given n non-negative integers a1, a2, ..., an,
	where each represents a point at coordinate (i, ai). 
	n vertical lines are drawn such that the two endpoints of line i is at (i, ai) 
	and (i, 0). Find two lines, which together with x-axis forms a container, 
	such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
*/

public class ContainerWithMostWater{
	public static void main(String[] args){
		int[] height = new int[args.length];
		for(int i = 0; i < height.length; i++){
			height[i] = Integer.parseInt(args[i]);
		}
		System.out.println(maxArea(height));
	}

	static public int maxArea(int[] height) {
		int maxArea = 0, minLine = 0;
		int leftIndex = 0, rightIndex = height.length - 1;

		while(leftIndex < rightIndex){
			int min = height[leftIndex] < height[rightIndex] ? height[leftIndex] : height[rightIndex];
			if(min > minLine){
				minLine = min;
				int area = (rightIndex - leftIndex) * min;
				if(maxArea < area){
					maxArea = area;
				}
			}

			if(height[leftIndex] < height[rightIndex]){
				leftIndex++;
			}else{
				rightIndex--;
			}
		}

		return maxArea;
	}



/*	static public int maxArea_back(int[] height) {
		if(height.length < 2)
			return 0;
		int highestIndex = 0, lineIndex = 0, lineHeight = 0;
		int maxArea = 0;
		Stack<Integer> indexStack = new Stack<Integer>();
		indexStack.push(0);

		for(int i = 1, len = height.length; i < len; i++){
			if(height[highestIndex] < height[i]){
				int area = (i - highestIndex) * height[highestIndex];
				if(area > maxArea){
					maxArea = area;
				}
				highestIndex = i;
				indexStack.clear();
				indexStack.push(i);
			}else{
				while(height[indexStack.peek()] < height[i]){
					indexStack.pop();
				}
				indexStack.push(i);
			}
		}

		int currentIndex = 0;
		if(!indexStack.empty())
			currentIndex = indexStack.pop();
		while(!indexStack.empty()){
			int i = indexStack.pop();
			int area = (currentIndex - i) * height[currentIndex];
			if(area > maxArea){
				maxArea = area;
			}
			if(height[i] != height[currentIndex]){
				currentIndex = i;
			}
		}

		return maxArea;
	}*/
}