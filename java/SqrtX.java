/*
	problem 69
	Implement int sqrt(int x).
	Compute and return the square root of x.
*/

public class SqrtX {
	public static void main(String[] args) {
		System.out.println(mySqrt(Integer.parseInt(args[0])));
	}

	public static int mySqrt(int x) {
		if(x <= 0) return 0;
		if(x == 1) return 1;
		int small = 0, large = x / 2;

		while (large - small > 1) {
			int mid = (small + large) / 2;
			if (mid > x / mid) {
				large = mid - 1;
			} else {
				small = mid;
			}
		}

		return (large > (x / large)) ? small : large;
	}
}