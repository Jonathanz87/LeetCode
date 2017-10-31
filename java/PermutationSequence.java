/*
	problem 60
	The set [1,2,3,…,n] contains a total of n! unique permutations.
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
		"123"
		"132"
		"213"
		"231"
		"312"
		"321"
	Given n and k, return the kth permutation sequence.
	Note: Given n will be between 1 and 9 inclusive.
*/

/*
	solution
	for a n digit number, the combination of the sequence is 
	n * (n-1)!
	for example, if n = 4
	1xxx
	2xxx
	3xxx
	4xxx

	if k = 9
	position = (k - 1) / ((stack.length) - 1)!
	string = 		stack 1234
	string = 2 		stack 134
	string = 23		stack 14
	string = 231	stack 4
	string = 2314	stack
*/

public class PermutationSequence {
	public static void main(String[] args) {
		System.out.println(getPermutation(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	public static String getPermutation(int n, int k) {
		int[] factorial = new int[n + 1];
		char[] num = new char[n];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		if (k <= 0 || k > factorial[n]) {
			return "";
		}
		k--;

		for (int i = 0; i < num.length; i++) {
			num[i] = (char)(i + 1 + '0');
		}
		int offset = 0;

		while (--n > 0) {
			move(num, k / factorial[n] + offset, offset);
			k %= factorial[n];
			offset++;
		}

		return new String(num);
	}

	public static void move(char[] charArray, int from, int to) {
		char temp = charArray[from];
		while(from != to){
			charArray[from] = charArray[from - 1];
			from--;
		}
		charArray[to] = temp;
	}
}