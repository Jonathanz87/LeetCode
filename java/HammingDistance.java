/*
	problem 461
	The Hamming distance between two integers is the number of positions at
	which the corresponding bits are different.
	Given two integers x and y,
	calculate the Hamming distance.
	Note:
	0 ≤ x, y < 231.
	Example:
		Input: x = 1, y = 4
		Output: 2
		Explanation:
		1   (0 0 0 1)
		4   (0 1 0 0)
		       ↑   ↑
		The above arrows point to positions where the corresponding bits are different.
*/

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
    public static int hammingDistance(int x, int y) {
        int difference = x ^ y;
        int hammingDistance = 0;
        while(difference > 0) {
            hammingDistance += difference & 1;
            difference >>>= 1;
        }
        return hammingDistance;
    }
}