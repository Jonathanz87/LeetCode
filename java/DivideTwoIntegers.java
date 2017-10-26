/*
	Divide two integers without using multiplication,
	division and mod operator.
	If it is overflow, return MAX_INT.
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int d = divisor, doubleD = d + d;
        if(divisor < dividend) {
            return 0;
        }
        int result = 1;
        while(doubleD > d && dividend >= doubleD) {
            result += result;
            d = doubleD;
            doubleD += doubleD;
        }

        return result + divide(dividend - d, divisor);
    }
}