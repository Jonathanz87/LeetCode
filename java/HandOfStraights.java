
/*
    846. Hand of Straights
    Alice has a hand of cards, given as an array of integers.
    Now she wants to rearrange the cards into groups so 
    that each group is size W, and consists of W consecutive cards.
    Return true if and only if she can.
    Example 1:
        Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
        Output: true
        Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
    Example 2:
        Input: hand = [1,2,3,4,5], W = 4
        Output: false
        Explanation: Alice's hand can't be rearranged into groups of 4.
    Note:
        1 <= hand.length <= 10000
        0 <= hand[i] <= 10^9
        1 <= W <= hand.length
*/

import java.util.Arrays;

public class HandOfStraights {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 }, 3));
    }

    // for any W consecutive cards, n1 ... nw
    // the mod value for those
    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length % W != 0) {
            return false;
        }

        if (W == 1) {
            return true;
        }

        int[] modCount
    }

    public static boolean isNStraightHand2(int[] hand, int W) {
        if (hand == null || hand.length % W != 0) {
            return false;
        }

        if (W == 1) {
            return true;
        }

        Arrays.sort(hand);

        int[] stageTable = new int[W - 1];
        int lastNumber = -1;
        int count = 0;
        int stageCount = 0;

        for (int n : hand) {
            if (n == lastNumber) {
                count++;
            } else {
                stageCount = fill(stageTable, count);
                if (stageCount < 0 || (stageCount != 0 && n != lastNumber + 1)) {
                    return false;
                }
                lastNumber = n;
                count = 1;
            }
        }

        return fill(stageTable, count) == 0;
    }

    public static int fill(int[] stageTable, int count) {
        int stageCount = 0;
        for (int i = stageTable.length - 1; i > 0; i--) {
            count -= stageTable[i];
            stageTable[i] = stageTable[i - 1];
            stageCount += stageTable[i];
        }
        count -= stageTable[0];
        stageTable[0] = count;
        stageCount += count;

        return count >= 0 ? stageCount : -1;
    }

}