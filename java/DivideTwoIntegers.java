/*
	problem 29
	Divide two integers without using multiplication,
	division and mod operator.
	If it is overflow, return MAX_INT.
*/

public class DivideTwoIntegers {
    public static int divide2(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("/ by zero");

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long dividendLong = Math.abs((long) dividend), divisorLong = Math.abs((long) divisor), answer = 0;
        
        while (dividendLong >= divisorLong) {
            int factor = 1;
            long divis = divisorLong;
            while (dividendLong >= divis + divis) {
                factor += factor;
                divis += divis;
            }

            dividendLong -= divis;
            answer += factor;
        }

        return (int)(isNegative ? -answer : answer);
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("/ by zero");
        long dividendLong = dividend, dvisorLong = divisor;
        boolean isPositive = true;
        if (dividendLong < 0) {
            dividendLong = -dividendLong;
            isPositive = !isPositive;
        }

        if (dvisorLong < 0) {
            dvisorLong = -dvisorLong;
            isPositive = !isPositive;
        }

        long answer = divideHelp(dividendLong, dvisorLong);
        if (!isPositive) {
            answer = -answer;
        }
        if (answer > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) answer;
    }

    public static long divideHelp(long dividend, long divisor) {
        if (divisor > dividend) {
            return 0;
        }
        long d = divisor, doubleD = d + d;
        long result = 1;
        while (dividend >= doubleD) {
            result += result;
            d = doubleD;
            doubleD += doubleD;
        }

        return result + divideHelp(dividend - d, divisor);
    }
}