/*
	java screening question 1
*/

import java.util.List;
import java.util.ArrayList;

public class SecondLargestValue{
	public static void main(String[] args){
		List<Integer> values = new ArrayList<Integer>();

		for(int i = 0, len = args[0].length(); i < len; i++){
			values.add(args[0].charAt(i) - '0');
		}

		System.out.println(findSecondLargestValue(values));
	}

	public static int findSecondLargestValue(List<Integer> values){
		if(values.size() <= 1){
			throw new RuntimeException("Must contain two or more integers.");
		}

		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

		for(int i = 0, len = values.size(); i < len; i++){
			int temp;
			if((temp = values.get(i)) > largest){
				secondLargest = largest;
				largest = temp;
			}else if(temp > secondLargest){
				secondLargest = temp;
			}
		}

		return secondLargest;
	}
}