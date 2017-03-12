/*
	problem 9
	Determine whether an integer is a palindrome.
	Do this without extra space.
*/

public class PalindromeNumber{

	static public void main(String[] args){
		System.out.println(isPalindrome(Integer.parseInt(args[0])));
	}

	static public boolean isPalindrome(int x) {
		if(x < 0 || (x!=0 && x%10==0)) return false;

		int temp = 0;
		while (x > temp){
			temp = temp * 10 + x % 10;
			x /= 10;
		}

		return temp == x || temp / 10 == x;
	}
}