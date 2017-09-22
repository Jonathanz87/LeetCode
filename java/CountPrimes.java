/*
	problem 204
	Description:
	Count the number of prime numbers less than a non-negative number, n.
*/

public class CountPrimes {
	public int countPrimes(int n) {
		if(n <= 2) return 0;
		if(n == 3) return 1;

		boolean[] isPrime = new boolean[n];
		int count = 1;

		for (int i = 3; i < n; i += 2) {
			if (!isPrime[i]) {
				count++;
				for (int j = i + i; j < n; j += i) {
					isPrime[j] = true;
				}
			}
		}
		return count;
	}
}