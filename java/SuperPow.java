/*
	problem 372
	Your task is to calculate ab mod 1337 where
	a is a positive integer and b is an extremely large positive integer
	given in the form of an array.
	Example 1:
		a = 2
		b = [3]
		Result: 8
	Example 2:
		a = 2
		b = [1,0]
		Result: 1024
*/

public class SuperPow {
    private final static int FILTER = 1337;
    public static int superPow(int a, int[] b) {
        a %= FILTER;
        int result = 1;

        for (int e : b) {
            result = power(result, 10) * power(a, e) % FILTER;
        }

        return result;
    }

    private static int power(int b, int e) {
        b %= FILTER;
        int result = 1;
        for (int i = 0; i < e; i++) {
            result = result * b % FILTER;
        }

        return result;
    }
}