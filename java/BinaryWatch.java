/*
	problem 401
	A binary watch has 4 LEDs on the top which represent the hours (0-11),
	and the 6 LEDs on the bottom represent the minutes (0-59).
	Each LED represents a zero or one,
	with the least significant bit on the right.
	For example,
		the above binary watch reads "3:25".
		Given a non-negative integer n
		which represents the number of LEDs that are currently on,
		return all possible times the watch could represent.
	Example:
		Input: n = 1
		Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
	Note:
		The order of output does not matter.
		The hour must not contain a leading zero,
		for example "01:00" is not valid, it should be "1:00".
		The minute must be consist of two digits and may contain a leading zero,
		for example "10:2" is not valid, it should be "10:02".
*/

import java.util.List;
import java.util.ArrayList;

public class BinaryWatch {
	public static void main(String[] args) {
		
	}

	public static List<String> readBinaryWatch(int num) {
		boolean[] leds = new boolean[10];
		List<String> timeList = new ArrayList<>();

		readBinaryWatch(timeList, leds, 0, num);
		return timeList;
	}

	public static void readBinaryWatch(List<String> timeList, boolean[] leds, int index, int num) {
		if (num <= 0) {
			String time = getTime(leds);
			if (time != null) {
				timeList.add(time);
			}
			return;
		}

		if (index >= leds.length || leds.length - index < num) {
			return;
		}


		readBinaryWatch(timeList, leds, index + 1, num);

		leds[index] = true;
		readBinaryWatch(timeList, leds, index + 1, num - 1);
		leds[index] = false;
	}

	public static String getTime(boolean[] leds) {
		int hour = 0, minute = 0;
		for (int i = 3; i >= 0; i--) {
			hour = (hour << 1) | (leds[i] ? 1 : 0);
		}
		if (hour > 11) return null;

		for (int i = 9; i >= 4; i--) {
			minute = (minute << 1) | (leds[i] ? 1 : 0);
		}
		if (minute > 59) return null;

		return String.valueOf(hour + ":" + (minute > 9 ? "" : "0") + minute);
	}

}