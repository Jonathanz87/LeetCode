/*
	problem 343
	Given a positive integer n,
	break it into the sum of at least two positive integers
	and maximize the product of those integers.
	Return the maximum product you can get.
	For example,
		given n = 2, return 1 (2 = 1 + 1);
		given n = 10, return 36 (10 = 3 + 3 + 4).
	Note: You may assume that n is not less than 2 and not larger than 58.
*/
/*
	solution
	2 = 1 * 1
	3 = 2 * 2
	4 = 2 * 2
	5 = 3 * 2
	6 = 3 * 3
	7 = 3 * 2 * 2
	8 = 3 * 3 * 2
	9 = 3 * 3 * 3
	10 = 3 * 3 * 2 * 2
	...
*/
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;

        int threes = n / 3;
        int remainder = n % 3;
        if(remainder == 0) {
            remainder == 1;
        } else if(remainder == 1) {
            threes--;
            remainder = 4;
        }

        return Math.pow(3, threes) * remainder;
    }
}