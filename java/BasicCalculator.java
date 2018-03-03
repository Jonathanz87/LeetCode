/*
	problem 224
	Implement a basic calculator to evaluate a simple expression string.
	The expression string may contain open ( and closing parentheses ), 
	the plus + or minus sign -, non-negative integers and empty spaces .
	You may assume that the given expression is always valid.
	Some examples:
		"1 + 1" = 2
		" 2-1 + 2 " = 3
		"(1+(4+5+2)-3)+(6+8)" = 23
*/

public class BasicCalculator{
	public static void main(String[] args){
		System.out.println(calculate(args[0]));
	}
	public static int calculate(String s) {
        int size = s.length();
        int[] numStack = new int[size/2+1];
        boolean[] plusStack = new boolean[size/2+1];
        int index = 0;
        boolean isPlus = true;
        int result = 0;
        int num = 0;

        for(char c : s.toCharArray()){
        	if(Character.isDigit(c)){
        		num = num * 10 + c - '0';
        	}else if(c == '('){
        		numStack[index] = result;
        		plusStack[index++] = isPlus;
        		isPlus = true;
        		result = 0;
        		num = 0;
        	}else if(c == ')'){
        		result += isPlus ? num : -num;
        		result = numStack[--index] + (plusStack[index] ? result : -result);
        		num = 0;
        	}else if(c == '+'){
        		result += isPlus ? num : -num;
        		isPlus = true;
        		num = 0;
        	}else if(c == '-'){
        		result += isPlus ? num : -num;
        		isPlus = false;
        		num = 0;
        	}
        }
		result += isPlus ? num : -num;
        return result;
    }

}
