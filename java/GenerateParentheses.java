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
		}else if(args[1].equals("2")){
			long startTime=System.nanoTime();
			generateParenthesis2(Integer.parseInt(args[0]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}else if(args[1].equals("3")){
			long startTime=System.nanoTime();
			generateParenthesis3(Integer.parseInt(args[0]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}
		else if(args[1].equals("4")){
			long startTime=System.nanoTime();
			generateParenthesis4(Integer.parseInt(args[0]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}
	}

	static private class StringQuequ{
		private String val;
		private int left, right;
		private StringQuequ next;
		private StringQuequ(String val, int left, int right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static public List<String> generateParenthesis4(int n) {
		List<String> result = new ArrayList<String>();
		int size = n * n * n;
		String[] str = new String[size];
		int[] left = new int[size];
		int[] right = new int[size];

		int head = 0, tail = 0;
		int len = n * 2;
		str[head] = "(";
		left[head] = n - 1;
		right[head] = n;

		while(head <= tail){
			if(str[head].length() >= len){
				result.add(str[head]);
				head++;
				continue;
			}

			if(left[head] > 0){
				str[++tail] = str[head] + "(";
				left[tail] = left[head] - 1;
				right[tail] = right[head];
			}
			if(right[head] > left[head]){
				str[++tail] = str[head] + ")";
				left[tail] = left[head];
				right[tail] = right[head] - 1;
			}
			head++;
		}
		return result;
	}

	static public List<String> generateParenthesis3(int n) {
		List<String> result = new ArrayList<String>();
		StringQuequ head = new StringQuequ("(", n - 1, n);
		StringQuequ tail = head;
		int len = n * 2;

		while(head != null){
			if(head.val.length() >= len){
				result.add(head.val);
				head = head.next;
				continue;
			}

			if(head.left > 0){
				tail.next = new StringQuequ(head.val + "(", head.left - 1, head.right);
				tail = tail.next;
			}
			if(head.right > head.left){
				tail.next = new StringQuequ(head.val + ")", head.left, head.right - 1);
				tail = tail.next;
			}
			head = head.next;
		}
		return result;
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

	static public List<String> generateParenthesis2(int n) {
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