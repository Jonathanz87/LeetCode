/*
    problem 451
    Given a string, sort it in decreasing order based on the frequency of characters.
    Example 1:
        Input:  "tree"
        Output: "eert"
        Explanation:
        'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
    Example 2:
        Input:  "cccaaa"
        Output: "cccaaa"
        Explanation:
        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
        Note that "cacaca" is incorrect, as the same characters must be together.
    Example 3:
        Input:  "Aabb"
        Output: "bbAa"
        Explanation:
        "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
 */
import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {
    public static void main(String[] args){
        args = new String[]{"tree"};
        System.out.println(frequencySort(args[0]));
    }
    public static String frequencySort(String s) {
        int[] frequencyCount = new int[128];
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            frequencyCount[c]++;
        }

        int[][] countIndex = new int[frequencyCount.length][2];

        for (int i = 0; i < countIndex.length; i++) {
            countIndex[i][0] = frequencyCount[i];
            countIndex[i][1] = i;
        }

        Arrays.sort(countIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int[] i : countIndex){
            while(frequencyCount[i[1]]-- > 0){
                builder.append((char) i[1]);
            }
        }

        return builder.toString();
    }
}
