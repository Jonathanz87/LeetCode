/*
	problem 134
	There are N gas stations along a circular route,
	where the amount of gas at station i is gas[i].
	You have a car with an unlimited gas tank and
	it costs cost[i] of gas to travel from station i to its next station (i+1).
	You begin the journey with an empty tank at one of the gas stations.
	Return the starting gas station's index
	if you can travel around the circuit once,
	otherwise return -1.
	Note:
	The solution is guaranteed to be unique.
*/

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0) return -1;
		if (gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
		int tank = -1, startIndex = -1;

		for (int count = 0, i = 0, len = gas.length * 2; count < len; count++, i = (i + 1) >= gas.length ? 0 : (i + 1)) {
			if (tank < 0) {
				tank = 0;
				startIndex = i;
			} else if (i == startIndex) {
				return startIndex;
			}

			tank += gas[i] - cost[i];
		}

		return -1;
	}

	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int tank = 0, startIndex = 0, totalUsage = 0;

		for (int i = 0, len = gas.length; i < len; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				totolUsage += tank;
				tank = 0;
				startIndex = i + 1;
			}
		}

		return tank + totolUsage < 0 ? -1 : startIndex;
	}
}