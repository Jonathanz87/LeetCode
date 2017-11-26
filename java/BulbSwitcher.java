/*
	problem 319
	There are n bulbs that are initially off.
	You first turn on all the bulbs.
	Then, you turn off every second bulb. On the third round,
	you toggle every third bulb (turning on if it's off or turning off if it's on).
	For the ith round, you toggle every i bulb.
	For the nth round,
	you only toggle the last bulb.
	Find how many bulbs are on after n rounds.
	Example:
		Given n = 3.
		At first, the three bulbs are [off, off, off].
		After first round, the three bulbs are [on, on, on].
		After second round, the three bulbs are [on, off, on].
		After third round, the three bulbs are [on, off, off].
		So you should return 1, because there is only one bulb is on.
*/

public class BulbSwitcher {
	public static void main(String[] args) {
		System.out.println(bulbSwitch(Integer.parseInt(args[0])));
	}

	public int bulbSwitch2(int n) {
		return (int)Math.sqrt(n);
	}
	public static int bulbSwitch(int n) {
		if (n <= 0) return 0;
		int[] switches = new int[n + 1];
		int bulbsCounter = 1;
		for (int i = 2; i <= n; i++) {
			int num = i * 2;
			while (num <= n) {
				switches[num]++;
				num += i;
			}
			bulbsCounter += switches[i] % 2;
		}

		return bulbsCounter;
	}
}