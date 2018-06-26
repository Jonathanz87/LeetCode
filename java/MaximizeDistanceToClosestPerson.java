/*
	problem 849
	In a row of seats, 1 represents a person sitting in that seat,
	and 0 represents that the seat is empty.
	There is at least one empty seat, and at least one person sitting.
	Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
	Return that maximum distance to closest person.
	Example 1:
		Input: [1,0,0,0,1,0,1]
		Output: 2
		Explanation:
		If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
		If Alex sits in any other open seat, the closest person has distance 1.
		Thus, the maximum distance to the closest person is 2.
	Example 2:
		Input: [1,0,0,0]
		Output: 3
	Explanation:
		If Alex sits in the last seat, the closest person is 3 seats away.
		This is the maximum distance possible, so the answer is 3.
*/

public class MaximizeDistanceToClosestPerson {
	public static void main(String[] args) {
		int[] seats = new int[args.length];
		for (int i = 0; i < seats.length; i++) {
			seats[i] = Integer.parseInt(args[i]);
		}

		System.out.println(maxDistToClosest(seats));
	}
	public static int maxDistToClosest(int[] seats) {
		int l = 0, r = seats.length - 1;
		int max = 0;
		int maxZeros = 0;
		int zeros = 0;
		while (seats[l] == 0) {
			l++;
		}

		while (seats[r] == 0) {
			r--;
		}

		max = Math.max(l, seats.length - 1 - r);
		while (l <= r) {
			if (seats[l] == 0) {
				zeros++;
			} else {
				maxZeros = Math.max(zeros, maxZeros);
				zeros = 0;
			}
			l++;
		}

		return Math.max(max, (maxZeros + 1) / 2);
	}
}