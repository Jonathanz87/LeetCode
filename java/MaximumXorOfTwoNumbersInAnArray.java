/*
    421. Maximum XOR of Two Numbers in an Array
    Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
    Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
    Could you do this in O(n) runtime?
    Example:
            Input: [3, 10, 5, 25, 2, 8]
            Output: 28
            Explanation: The maximum result is 5 ^ 25 = 28. 
*/

public class MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));
    }

    private static class BinaryNode {
        private BinaryNode zero;
        private BinaryNode one;
        private int n;
    }

    private static void insert(BinaryNode root, int n) {
        for (int d = 31; d >= 0; d--) {
            if ((n & (1 << d)) > 0) {
                if (root.one == null) {
                    BinaryNode temp = new BinaryNode();
                    root.one = temp;
                }
                root = root.one;
            } else {
                if (root.zero == null) {
                    BinaryNode temp = new BinaryNode();
                    root.zero = temp;
                }
                root = root.zero;
            }
        }
        root.n = n;
    }

    private static int maxXor(BinaryNode root, int n) {
        for (int d = 31; d >= 0; d--) {
            if ((n & (1 << d)) > 0) {
                root = root.zero == null ? root.one : root.zero;
            } else {
                root = root.one == null ? root.zero : root.one;
            }
        }

        return n ^ root.n;
    }

    public static int findMaximumXOR(int[] nums) {
        int max = -1;
        BinaryNode root = new BinaryNode();
        for (int n : nums) {
            insert(root, n);
            max = Math.max(max, maxXor(root, n));
        }
        return max;
    }

}
