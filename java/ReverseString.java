/*
	problem 344
	Write a function that takes a string as input and returns the string reversed.
	Example:
		Given s = "hello", return "olleh".
*/

public class ReverseString {
    public String reverseString(String s) {
        char[] strArr = s.toCharArray();
        int leftIndex = 0, rightIndex = strArr.length - 1;

        while(leftIndex < rightIndex) {
            strArr[leftIndex] = (char)(strArr[leftIndex] ^ strArr[rightIndex]);
            strArr[rightIndex] = (char)(strArr[leftIndex] ^ strArr[rightIndex]);
            strArr[leftIndex] = (char)(strArr[leftIndex] ^ strArr[rightIndex]);
            leftIndex++;
            rightIndex--;
        }

        return new String(strArr);
    }
}