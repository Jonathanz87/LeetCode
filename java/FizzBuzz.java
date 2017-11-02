/*
	problem 412
	Write a program that outputs the string representation of numbers from 1 to n.
	But for multiples of three it should output “Fizz” instead of the number and
	for the multiples of five output “Buzz”.
	For numbers which are multiples of both three and five output “FizzBuzz”.
	Example:
		n = 15,
		Return:
		[
			"1",
			"2",
			"Fizz",
			"4",
			"Buzz",
			"Fizz",
			"7",
			"8",
			"Fizz",
			"Buzz",
			"11",
			"Fizz",
			"13",
			"14",
			"FizzBuzz"
		]
*/

import java.util.List;
import java.util.LinkedList;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new LinkedList<>();
        int num = 1;
        while(num <= n) {
            String str = "";
            if(num % 3 == 0) {
                str += "Fizz";
            }
            if(num % 5 == 0) {
                str += "Buzz";
            }

            if(str.length() <= 0) {
                str += num;
            }
            num++;
            resultList.add(str);
        }

        return resultList;
    }
}