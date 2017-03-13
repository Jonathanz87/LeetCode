/*
	problem 22
	Given n pairs of parentheses, 
	write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:
	[
		"((()))",
		"(()())",
		"(())()",
		"()(())",
		"()()()"
	]
*/

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class GenerateParentheses{
	static public void main(String[] args){
		if(args[1].equals("1")){
			long startTime=System.nanoTime();
			generateParenthesis(Integer.parseInt(args[0]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}else{
			long startTime=System.nanoTime();
			generateParenthesis2(Integer.parseInt(args[0]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}
	}

	static public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		leftStack.push(n - 1);
		rightStack.push(n);

		int len = n * 2;
		stack.push("(");

		while(!stack.empty()){
			String temp = stack.pop();
			int left = leftStack.pop();
			int right = rightStack.pop();

			if(temp.length() >= len){
				result.add(temp);
				continue;
			}

			if(left > 0){
				leftStack.push(left - 1);
				rightStack.push(right);
				stack.push(temp + "(");
			}
			if(right > left){
				leftStack.push(left);
				rightStack.push(right - 1);
				stack.push(temp + ")");
			}
		}
		return result;
	}

	static public ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
	static public void helper(ArrayList<String> result,
	                   String paren, // current paren
	                   int left,     // how many left paren we need to add
	                   int right) {  // how many right paren we need to add
		if (left == 0 && right == 0) {
			result.add(paren);
			return;
		}

        if (left > 0) {
		    helper(result, paren + "(", left - 1, right);
        }
        
        if (right > 0 && left < right) {
		    helper(result, paren + ")", left, right - 1);
        }
	}
}