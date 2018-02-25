/*
	problem 680
	Given a non-empty string s, 
	you may delete at most one character. 
	Judge whether you can make it a palindrome.
	Example 1:
		Input: "aba"
		Output: True
	Example 2:
		Input: "abca"
		Output: True
		Explanation: You could delete the character 'c'.
	Note:
		The string will only contain lowercase characters a-z. 
		The maximum length of the string is 50000.
*/

public class ValidPalindromeII{
	public static void main(String[] args){
		System.out.println(validPalindrome(args[0]));
	}

    public static boolean validPalindrome(String s) {
		char[] c = s.toCharArray();
		int leftIndex = 0;
		int rightIndex = s.length() - 1;
		while(leftIndex <= rightIndex){
			if(c[leftIndex] != c[rightIndex]){
				return isValidPalindrome(c, leftIndex + 1, rightIndex) || isValidPalindrome(c, leftIndex, rightIndex - 1);
			}
			leftIndex++;
			rightIndex--;
		}
		return true;
    }

    public static boolean isValidPalindrome(char[] c, int leftIndex, int rightIndex){
    	while(leftIndex <= rightIndex){
    		if(c[leftIndex] != c[rightIndex]){
    			return false;
    		}
    		leftIndex++;
    		rightIndex--;
    	}
    	return true;
    }
}
