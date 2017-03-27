/*
	problem 32
	Given a string containing just the characters '(' and ')',
	find the length of the longest valid (well-formed) parentheses substring.
	For "(()", the longest valid parentheses substring is "()",
	which has length = 2.
	Another example is ")()())",
	where the longest valid parentheses substring is "()()",
	which has length = 4.
*/

public class LongestValidParentheses{
	static public void main(String[] args){
		System.out.println(longestValidParentheses(args[0]));
	}

	static public int longestValidParentheses(String s){
		int[] valueStack = new int[s.length()];
		int index = -1, longest = 0;

		for(int i = 0, len = s.length(); i < len; i++){
			if(s.charAt(i) == '('){
				valueStack[++index] = 0;
			}else{
				int value = 0;
				while(index >= 0 && valueStack[index] != 0){
					value += valueStack[index--];
				}
				while(index > 0 && valueStack[index - 1] != 0){
					value += valueStack[--index];
				}
				if(index >= 0){
					value += 2;
					valueStack[index] = value;
				}
				if(value > longest){
					longest = value;
				}
			}
		}
		return longest;
	}
}