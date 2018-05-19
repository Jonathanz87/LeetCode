/*
	problem 743
	There are N network nodes, labelled 1 to N.
	Given times, a list of travel times as directed edges times[i] = (u, v, w),
	where u is the source node, v is the target node,
	and w is the time it takes for a signal to travel from source to target.
	Now, we send a signal from a certain node K.
	How long will it take for all nodes to receive the signal?
	If it is impossible, return -1.
	Note:
		N will be in the range [1, 100].
		K will be in the range [1, N].
		The length of times will be in the range [1, 6000].
		All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
*/

import java.util.List;
import java.util.LinkedList;

public class NetworkDelayTime {
	public static int networkDelayTime2(int[][] times, int N, int K) {
		int[][] timeMap = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] source = timeMap[K - 1];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				timeMap[i][j] = -1;
			}
		}

		for (int[] time : times) {
			timeMap[time[0] - 1][ time[1] - 1] = time[2];
		}

		source[K - 1] = 0;
		visited[K - 1] = true;

		while (true) {
			int smallestTime = Integer.MAX_VALUE;
			int[] sminallestIndex = -1;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && source[i] >= 0 && source[i] < smallestTime) {
					smallestTime = source[i];
					smallestIndex = i;
				}
			}
			if (smallestIndex == -1) break;
			visited[smallestIndex] = true;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && timeMap[smallestIndex][i] >= 0) {
					if (source[i] == -1) {
						source[i] = smallestTime + timeMap[smallestIndex][i];
					} else {
						source[i] = Math.min(source[i], smallestTime + timeMap[smallestIndex][i]);
					}
				}
			}
		}
		for (int n : source) {
			if (n == -1) {
				return -1;
			}
			max = Math.max(max, n);
		}

		return max;
	}

	public static int networkDelayTime(int[][] times, int N, int K) {
		int[] timeMap = new int[N];
		List<int[]>[] paths = new LinkedList[N];
		int max = 0;
		for (int[] time : times) {
			int sourceId = time[0] - 1;
			if (paths[sourceId] == null) {
				paths[sourceId] = new LinkedList<>();
			}
			paths[sourceId].add(new int[] {time[1] - 1, time[2]});
		}

		for (int i = 0; i < timeMap.length; i++) {
			timeMap[i] = -1;
		}

		timeMap[K - 1] = 0;

		dsf(paths, timeMap, K - 1, 0);
		for (int t : timeMap) {
			if (t < 0) {
				return -1;
			}
			max = Math.max(max, t);
		}
		return max;
	}

	private static void dsf(List<int[]>[] paths, int[] timeMap, int sourceId, int time) {
		if (paths[sourceId] == null) return;
		for (int[] path : paths[sourceId]) {
			int newTime = time + path[1];
			if (timeMap[path[0]] < 0 || timeMap[path[0]] > newTime) {
				timeMap[path[0]] = newTime;
				dsf(paths, timeMap, path[0], newTime);
			}
		}
	}
}