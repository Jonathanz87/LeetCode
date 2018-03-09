/*
	problem 386
	Given an integer n, return 1 - n in lexicographical order.
	For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
	Please optimize your algorithm to use less time and space. 
	The input size may be as large as 5,000,000.
*/

import java.util.List;
import java.util.LinkedList;

public class LexicographicalNumbers {
	public static void main(String[] args){
		List<Integer> result = lexicalOrder(Integer.parseInt(args[0]));

		result.forEach(System.out::println);
	}

	public static List<Integer> lexicalOrder(int n) {
		List<Integer> intList = new LinkedList<>();
		for(int i = 1; i <= 9; i++){
			if(i > n){
				break;
			}
			intList.add(i);
			lexicalOrder(n, i, intList);
		}
		return intList;
	}

	public static void lexicalOrder(int n, int num, List<Integer> intList) {
		for (int i = 0; i <= 9; i++) {
			int temp = num * 10 + i;
			if (temp > n) {
				break;
			}
			intList.add(temp);
			lexicalOrder(n, temp, intList);
		}
	}
}
