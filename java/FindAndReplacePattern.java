/*
  problem 890
  You have a list of words and a pattern, and you want to know which words in words matches the pattern.
  A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x),
  we get the desired word.
  (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, 
  and no two letters map to the same letter.)
  Return a list of the words in words that match the given pattern.
  You may return the answer in any order.
  Example 1:
    Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
    since a and b map to the same letter.
  Note:
    1 <= words.length <= 50
    1 <= pattern.length = words[i].length <= 20
 */

import java.util.LinkedList;
import java.util.List;

public class FindAndReplacePattern {

  public static void main(String[] args){
    System.out.println(matchesPattern("mee", "abb"));
  }

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new LinkedList<>();

    for(String w : words){
      if(matchesPattern(w, pattern)){
        result.add(w);
      }
    }
    return result;
  }

  private static boolean matchesPattern(String str, String pattern) {
    boolean[] visited = new boolean[26];
    char[] matchMap = new char[26];
    char[] strCharArray = str.toCharArray();
    char[] patternArray = pattern.toCharArray();

    for (int i = 0; i < strCharArray.length; i++) {
      int charIndex = strCharArray[i] - 'a';
      if(matchMap[charIndex] == '\u0000'){
        int patternIndex = patternArray[i] - 'a';
        if(visited[patternIndex]){
          return false;
        }
        matchMap[charIndex] = patternArray[i];
        visited[patternIndex] = true;
      }else if(matchMap[charIndex] != patternArray[i]) {
         return false;
      }
    }

    return true;
  }
}
