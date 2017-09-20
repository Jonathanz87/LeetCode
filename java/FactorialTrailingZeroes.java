/*
	problem 172
	Given an integer n,
	return the number of trailing zeroes in n!.
	Note: Your solution should be in logarithmic time complexity.
*/

/*
	solution
	1		1					1
	2		2					2
	3		6					2*3
	4		24					2*2*2*3
	5		120					2*2*2*3*5
	6		720					2*2*2*2*3*3*5
	7		5040				2*2*2*2*3*3*5*7
	8		40320				2*2*2*2*2*2*2*3*3*5*7
	9		362880				2*2*2*2*2*2*2*3*3*3*3*5*7
	10		3628800				2*2*2*2*2*2*2*2*3*3*3*3*5*5*7
	...		...					...
	15		1307674368000		...*5*5*5*...
	...		...					...
	20		2432902008176640000 ...*5*5*5*5*...

	the number of 0s if effected by the number of factors of 2s and 5s.
	there always be enough 2s therefore,
	the number of 0s is equivalent to the number of factor 5
*/
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		return n < 5 ? 0 : n / 5;
	}
}