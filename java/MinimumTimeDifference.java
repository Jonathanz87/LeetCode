/*
	problem 539
	Given a list of 24-hour clock time points in "Hour:Minutes" format, 
	find the minimum minutes difference between any two time points in the list.
	Example 1:
		Input: ["23:59","00:00"]
		Output: 1
	Note:
		The number of time points in the given list is at least 2 and won't exceed 20000.
		The input time is legal and ranges from 00:00 to 23:59.
*/

import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
	public static void main(String[] args) {
		System.out.print(diff("11:58", "23:59"));
	}

	// time O(nlogn) mem O(1)
	public static int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints);
		int min = diff(timePoints.get(0), timePoints.get(timePoints.size() - 1));

		for (int i = 1, len = timePoints.size(); i < len; i++) {
			min = Math.min(diff(timePoints.get(i), timePoints.get(i - 1)), min);
		}
		return min;
	}

	private static int diff(String s1, String s2) {
		String[] t1 = s1.split(":");
		String[] t2 = s2.split(":");
		int diff = Math.abs(Integer.parseInt(t1[0]) * 60
		                    + Integer.parseInt(t1[1])
		                    - Integer.parseInt(t2[0]) * 60
		                    - Integer.parseInt(t2[1]));
		return diff > 720 ? 1440 - diff : diff;
	}

	// time O(n) use more mem
	public static int findMinDifference2(List<String> timePoints) {
		int size = 24 * 60;
		boolean[] time = new boolean[size];

		for (String s : timePoints) {
			int index = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
			if (time[index]) {
				return 0;
			}
			time[index] = true;
		}

		int fitst = Integer.MAX_VALUE, last = Integer.MIN_VALUE, pre = -size, min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (time[i]) {
				min = Math.min(min, i - pre);
				fitst = Math.min(fitst, i);
				last = Math.max(last, i);
				pre = i;
			}
		}

		int dif = Math.abs(fitst - last);
		if (dif > 720) {
			dif = size - dif;
		}
		return Math.min(min, dif);
	}
}
