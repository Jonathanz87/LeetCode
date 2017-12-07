/*
	problem 507
	We define the Perfect Number is a positive integer
	that is equal to the sum of all its positive divisors except itself.
	Now, given an integer n,
	write a function that returns true when it is a perfect number and false when it is not.
	Example:
		Input: 28
		Output: True
		Explanation: 28 = 1 + 2 + 4 + 7 + 14
		Note: The input number n will not exceed 100,000,000. (1e8)
*/

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num <= 0) return false;
        int sum = 1;
        int len = (int)Math.sqrt(num);
        for(int i = 2; i < len; i++) {
            if(num % i == 0) {
                sum += i + num / i;
            }
        }

        if(num % len == 0) {
            int d = (num / len);
            if(d == len) {
                sum += len;
            } else {
                sum += len + d;
            }
        }

        return sum == num;
    }
}