import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/*
    problem 1002. Find Common Characters
    Given an array A of strings made only from lowercase letters, 
    return a list of all characters that show up in all strings within the list (including duplicates).  
    For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
    You may return the answer in any order.
    Example 1:
        Input: ["bella","label","roller"]
        Output: ["e","l","l"]
    Example 2:
        Input: ["cool","lock","cook"]
        Output: ["c","o"]
    Note:
        1 <= A.length <= 100
        1 <= A[i].length <= 100
        A[i][j] is a lowercase letter
*/

public class FindCommonCharacters {
    public static void main(String[] args) {
        commonChars(new String[] { "bella", "label", "roller" }).forEach(System.out::println);
    }

    public static List<String> commonChars(String[] A) {
        List<String> letterList = new LinkedList<>();
        int[] letterCount = new int[26];
        Arrays.fill(letterCount, Integer.MAX_VALUE);

        for (String word : A) {
            int[] letters = new int[26];
            for (char c : word.toCharArray()) {
                letters[c - 'a']++;
            }
            for (int i = 0; i < letterCount.length; i++) {
                letterCount[i] = Math.min(letterCount[i], letters[i]);
            }
        }

        for (int i = 0; i < letterCount.length; i++) {
            char c = (char) (i + 'a');
            int ct = letterCount[i];

            while (ct-- > 0) {
                letterList.add(String.valueOf(c));
            }
        }

        return letterList;
    }
}