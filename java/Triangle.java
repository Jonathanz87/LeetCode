/*
	problem 120
	Given a triangle, find the minimum path sum from top to bottom. 
	Each step you may move to adjacent numbers on the row below.
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	Note:
	Bonus point if you are able to do this using only O(n) extra space, 
	where n is the total number of rows in the triangle.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle{
	public static void main(String[] args){
		List<List<Integer>> numbers = new ArrayList<>();
//		numbers.add(Arrays.asList(2));
//		numbers.add(Arrays.asList(3,4));
//		numbers.add(Arrays.asList(6,5,7));
//		numbers.add(Arrays.asList(4,1,8,3));

		System.out.println(minimumTotal(numbers));
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
		int layer = triangle.size() - 1;
		while(layer > 0){
			for(int i = 0, len = triangle.get(layer).size() - 1; i < len; i++){
				int sum = triangle.get(layer - 1).get(i) + Math.min(triangle.get(layer).get(i), triangle.get(layer).get(i + 1));	
				triangle.get(layer - 1).set(i, sum);
			}
			layer--;
		}

		return triangle.size() > 0 ? triangle.get(0).get(0) : 0;
	}
}
