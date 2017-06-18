/*
	problem 125
	Given a string, determine if it is a palindrome, 
	considering only alphanumeric characters and ignoring cases.
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	Note:
	Have you consider that the string might be empty? 
	This is a good question to ask during an interview.
	For the purpose of this problem, we define empty string as valid palindrome.
*/

public class ValidPalindrome{
	public static void main(String[] args){
		System.out.println(args[0] + " is valid palindrome: " + isPalindrome(args[0]));
	}

	public static boolean isPalindrome(String s) {
		int fIndex = 0, bIndex = s.length() - 1;

		while(fIndex < bIndex){
			if(!Character.isLetterOrDigit(s.charAt(fIndex))){
				fIndex++;
			}else if(!Character.isLetterOrDigit(s.charAt(bIndex))){
				bIndex--;
			}else{
				if(Character.toLowerCase(s.charAt(fIndex)) != Character.toLowerCase(s.charAt(bIndex))){
					return false;
				}
				fIndex++;
				bIndex--;
			}
		}

		return true;
	}
}