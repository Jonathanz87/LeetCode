/*
	problem 258
	Given a non-negative integer num,
	repeatedly add all its digits until the result has only one digit.
	For example:
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	Follow up:
	Could you do it without any loop/recursion in O(1) runtime?
*/

/*
	solution
	digit root
	number		result
	0			0
	1			1
	2			2
	...			...
	10			1
	11			2
	12			3
	13			4
	...			...
	18			9
	when num = 0					result = 0
	when num > 0 and num % 9 != 0	result = num % 9
	when num != 0 and num % 9 == 0	result = 9 
*/

public class AddDigits {
	public int addDigits(int num) {
		return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
	}
}