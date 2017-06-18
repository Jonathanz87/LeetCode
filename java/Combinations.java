/*
	problem 77
	Given two integers n and k, 
	return all possible combinations of k numbers out of 1 ... n.
	For example,
	If n = 4 and k = 2, a solution is:
	[
		[2,4],
		[3,4],
		[2,3],
		[1,2],
		[1,3],
		[1,4],
	]
*/

import java.util.List;
import java.util.LinkedList;

public class Combinations{
	public static void main(String[] args){
		combine(Integer.parseInt(args[0]), Integer.parseInt(args[1]))
		.forEach(System.out::println);

	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> resultList = new LinkedList<>();
		boolean[] digits = new boolean[n];
		combine(resultList, digits, n, 0, k);
		return resultList;
	}

	public static void combine(List<List<Integer>> resultList, boolean[] digits, int n, int i, int k){
		if(k <= 0){
			List<Integer> combine = new LinkedList<Integer>();
			for(int j = 0, len = digits.length; j < len; j++){
				if(digits[j]){
					combine.add(j + 1);
				}
			}
			resultList.add(combine);
		}else{
			int endIndex = n - k;
			while(i <= endIndex){
				digits[i] = true;
				combine(resultList, digits, n, i + 1, k - 1);
				digits[i++] = false;
			}
		}
	}
}