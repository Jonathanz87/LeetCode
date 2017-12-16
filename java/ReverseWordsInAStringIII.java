/*
	problem 557
	Given a string,
	you need to reverse the order of characters in each word
	within a sentence while still preserving whitespace and initial word order.
	Example 1:
		Input: "Let's take LeetCode contest"
		Output: "s'teL ekat edoCteeL tsetnoc"
	Note: In the string,
	each word is separated by single space and there will not be any extra space in the string.
*/

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int lastSpaceIndex = -1;
        for(int i = 0, len = s.length(); i < len; i++) {
            if(s.charAt(i) == ' ') {
                for(int j = i - 1; j > lastSpaceIndex; j--) {
                    builder.append(s.charAt(j));
                }
                builder.append(' ');
                lastSpaceIndex = i;
            }
        }

        for(int i = s.length() - 1; i > lastSpaceIndex; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}