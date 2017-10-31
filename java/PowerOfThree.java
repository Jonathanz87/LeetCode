/*
	problem 326
	Given an integer,
	write a function to determine if it is a power of three.
*/

/*
	if a float number is an integer then float % 1 == 0
	when convert log 243^3 to log 243 / log 3, 
	because a round issue the answer is not accurate
	so need to do log10(243) / log10(3)
*/

public class PowerOfThree {
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(Integer.parseInt(args[0])));
	}

	public static boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
}