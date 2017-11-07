/*
	problem 434
	Count the number of segments in a string,
	where a segment is defined to be a contiguous sequence of non-space characters.
	Please note that the string does not contain any non-printable characters.
	Example:
		Input: "Hello, my name is John"
		Output: 5
*/

public class NumberOfSegmentsInAString {
	public static void main(String[] args){
		System.out.println(countSegments(args[0]));
	}

    public static int countSegments(String s) {
        boolean isSpace = true;
        int count = 0;
        for(int i = 0, len = s.length(); i < len; i++) {
            if(isSpace && s.charAt(i) != ' ' ){
            	count++;
            }

            isSpace = s.charAt(i) == ' ';
        }

        return count;
    }
}