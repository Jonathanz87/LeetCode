/*
	problem 735
	We are given an array asteroids of integers representing asteroids in a row.
	For each asteroid, the absolute value represents its size, 
	and the sign represents its direction (positive meaning right, negative meaning left). 
	Each asteroid moves at the same speed.
	Find out the state of the asteroids after all collisions. 
	If two asteroids meet, the smaller one will explode. 
	If both are the same size, both will explode. 
	Two asteroids moving in the same direction will never meet.
	Example 1:
		Input: 
		asteroids = [5, 10, -5]
		Output: [5, 10]
		Explanation: 
		The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
	Example 2:
		Input: 
		asteroids = [8, -8]
		Output: []
		Explanation: 
		The 8 and -8 collide exploding each other.
	Example 3:
		Input: 
		asteroids = [10, 2, -5]
		Output: [10]
		Explanation: 
		The 2 and -5 collide resulting in -5. 
		The 10 and -5 collide resulting in 10.
	Example 4:
		Input: 
		asteroids = [-2, -1, 1, 2]
		Output: [-2, -1, 1, 2]
		Explanation: 
		The -2 and -1 are moving left, 
		while the 1 and 2 are moving right.
		Asteroids moving the same direction never meet, 
		so no asteroids will meet each other.
	Note:
		The length of asteroids will be at most 10000.
		Each asteroid will be a non-zero integer in the range [-1000, 1000]..
*/


public class AsteroidCollision {
	public static void main(String[] args) {
		int[] asteroids = new int[args.length];

		for (int i = 0; i < args.length; i++) {
			asteroids[i] = Integer.parseInt(args[i]);
		}

		int[] result = asteroidCollision(asteroids);
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) {
			return new int[0];
		}
		int index = 0, i = 1;

		while (i < asteroids.length) {
			if (index >= 0 && asteroids[index] >= 0 && asteroids[i] < 0) {
				if (Math.abs(asteroids[index]) == Math.abs(asteroids[i])) {
					index--;
					i++;
				} else if (Math.abs(asteroids[index]) < Math.abs(asteroids[i])) {
					index--;
				} else {
					i++;
				}
			} else {
				asteroids[++index] = asteroids[i++];
			}
		}

		int[] result = new int[index + 1];

		for (int j = 0; j <= index; j++) {
			result[j] = asteroids[j];
		}

		return result;
	}
}
