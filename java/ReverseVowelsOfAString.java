/*
	problem 345
	Write a function that takes a string as input and reverse only the vowels of a string.
	Example 1:
		Given s = "hello", return "holle".
	Example 2:
		Given s = "leetcode", return "leotcede".
	Note:
	The vowels does not include the letter "y".
*/

public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        char[] strArray = s.toCharArray();
        int leftIndex = 0, rightIndex = strArray.length  - 1;

        while(leftIndex < rightIndex) {
            while(leftIndex < strArray.length && !isVowel(strArray[leftIndex])) {
                leftIndex++;
            }
            while(rightIndex >= 0 && !isVowel(strArray[rightIndex])) {
                rightIndex--;
            }
            if(leftIndex < rightIndex) {
                strArray[leftIndex] = (char)(strArray[leftIndex] ^ strArray[rightIndex]);
                strArray[rightIndex] = (char)(strArray[leftIndex] ^ strArray[rightIndex]);
                strArray[leftIndex] = (char)(strArray[leftIndex] ^ strArray[rightIndex]);
                leftIndex++;
                rightIndex--;
            }
        }

        return String.valueOf(strArray);
    }

    private static boolean isVowel(char c) {
        switch(c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            return true;
        }

        return false;
    }
}