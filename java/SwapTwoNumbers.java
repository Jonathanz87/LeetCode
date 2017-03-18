/*
	swap two numbers
*/

public class SwapTwoNumbers{
	static public void main(String[] args){
		int a = 1, b = 2;

		System.out.println(a + " " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a + " " + b);
	}
}
