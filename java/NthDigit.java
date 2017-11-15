/*
	problem 400
	Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	Note:
	n is positive and will fit within the range of a 32-bit signed integer (n < 231).
	Example 1:
		Input:
		3
		Output:
		3
	Example 2:
		Input:
		11
		Output:
		0
	Explanation:
		The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0,
		which is part of the number 10.
*/

public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(Integer.parseInt(args[0])));
    }

    public static int findNthDigit(int n) {
        int digitCount = 1;
        long numberCount = 9;

        while(n > numberCount * digitCount) {
            n -= numberCount * digitCount;
            digitCount++;
            numberCount *= 10;
        }
        n--;
        long num = n / digitCount + numberCount / 9;
        int digit = digitCount - n % digitCount;

        while(digit-- > 1) {
            num /= 10;
        }

        return (int)num % 10;
    }
}