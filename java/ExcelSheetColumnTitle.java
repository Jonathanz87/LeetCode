/*
	problem 168
	Given a positive integer,
	return its corresponding column title as appear in an Excel sheet.
		For example:
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
*/

public class ExcelSheetColumnTitle{
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++)
			System.out.println( i + " - " + convertToTitle(i));

	}
	private static final char[] DIGITS = {'Z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
	private final static int SIZE = DIGITS.length;
	
	public static String convertToTitle(int n){
		StringBuffer buf = new StringBuffer("");
		while(n > 0){
			 buf.insert(0, DIGITS[n % SIZE]);
			 n = (n - 1) / SIZE;
		}

		return new String(buf);
	}
}