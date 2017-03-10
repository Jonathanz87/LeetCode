/*
	problem 20
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
	determine if the input string is valid.

	The brackets must close in the correct order,
	"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses{
	static public void main(String[] args){
		System.out.println(isValid(args[0]));
	}

	static final private Map<Character, Character> map = new HashMap<Character, Character>();

	static{
		map.put('(',')');
		map.put('{','}');
		map.put('[',']');
	}

	static public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0, len = s.length(); i < len; i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				stack.push(map.get(c));
			}else if(map.containsValue(c)){
				if(stack.empty() || !stack.pop().equals(c)){
					return false;
				}
			}
		}
		return stack.empty();
	}
}