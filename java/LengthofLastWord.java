/*
	problem 58
	Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
	return the length of last word in the string.
	If the last word does not exist, return 0.
	Note: A word is defined as a character sequence consists of non-space characters only.
	For example, 
		Given s = "Hello World",
		return 5.
*/

public class LengthofLastWord{
	public static void main(String[] args){
		System.out.println(lengthOfLastWord(args[0]));
	}

	public static int lengthOfLastWord(String s){
		int index = s.length() - 1, length;

		for(; index >= 0 && s.charAt(index) == ' '; index--);
		length = index;
		for(; index >= 0 && s.charAt(index) != ' '; index--);
		return length - index;
	}
}