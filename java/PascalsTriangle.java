/*
	problem 118
	Given numRows, generate the first numRows of Pascal's triangle.
	For example, given numRows = 5,
	Return
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
*/

import java.util.List;
import java.util.LinkedList;

public class PascalsTriangle{
	public static void main(String[] args){
		List<List<Integer>> triangle = generate(Integer.parseInt(args[0]));

		for(List<Integer> list : triangle){
			system.out.println(list);
		}
	}


	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();

		for(int row = 1; row <= numRows; row++){
			List<Integer> newRow = new LinkedList<Integer>();
			for(int i = 0; i < row; i++){
				if(i == 0 || i == row){
					newRow.add(1);
				}else{
					newRow.add(triangle.get(row - 2).get(i - 1) + triangle.get(row - 2).get(i));
				}
			}
			triangle.add(newRow);
		}
		return triangle;
	}
}