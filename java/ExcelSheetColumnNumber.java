/*
	problem 171
	Related to question Excel Sheet Column Title
	Given a column title as appear in an Excel sheet,
	return its corresponding column number.
	For example:
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
*/

public class ExcelSheetColumnNumber{
	public static void main(String[] args){

	}

	public static int titleToNumber(String s){
		final int SIZE = 26;
		int num = 0;
		for(int i = 0, len = s.length(); i < len; i++){
			num = num * SIZE + (s.charAt(i) - 'A' + 1);
		}
		return num;
	}
}