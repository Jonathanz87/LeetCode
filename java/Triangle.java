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

public class Triangle{
	public static void main(String[] args){

	}
	public static int minimumTotal(List<List<Integer>> triangle) {
		int layer = triangle.size() - 1;
		while(layer > 0){
			for(int i = 0, len = triangle[layer].size() - 1; i < len; i++){
				triangle[layer - 1][i] += Math.min(triangle[layer][i], triangle[layer][i + 1]);
			}
		}

		return triangle.size() > 0 ? triangle[0][0] : 0;
	}
}
