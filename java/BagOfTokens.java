
/*
    948. Bag of Tokens
    You have an initial power P, an initial score of 0 points, and a bag of tokens.
    Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
    If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
    If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
    Return the largest number of points we can have after playing any number of tokens.
    Example 1:
        Input: tokens = [100], P = 50
        Output: 0
    Example 2:
        Input: tokens = [100,200], P = 150
        Output: 1
    Example 3:
        Input: tokens = [100,200,300,400], P = 200
        Output: 2
    Note:
        tokens.length <= 1000
        0 <= tokens[i] < 10000
        0 <= P < 10000
*/
import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int point = 0;
        int l = 0, r = tokens.length - 1;
        int pointCache = 0, pCache = 0;
        while (l <= r) {
            if (P + pCache >= tokens[l]) {
                P = P + pCache - tokens[l++];
                point += 1 + pointCache;
                pCache = 0;
                pointCache = 0;
            } else if(point > 0){
                pCache += tokens[r--];
                pointCache -= 1;
            }else{
                break;
            }
        }

        return point;
    }
}