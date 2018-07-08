/*
	problem 797
	Given a directed, acyclic graph of N nodes.
	Find all possible paths from node 0 to node N-1, and return them in any order.
	The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
	graph[i] is a list of all nodes j for which the edge (i, j) exists.
	Example:
		Input: [[1,2], [3], [3], []]
		Output: [[0,1,3],[0,2,3]]
		Explanation: The graph looks like this:
		0--->1
		|    |
		v    v
		2--->3
		There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
	Note:
		The number of nodes in the graph will be in the range [2, 15].
		You can print different paths in any order,
		but you should keep the order of nodes inside one path.
*/

import java.util.List;
import java.util.LinkedList;

public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new LinkedList<>();
		if (graph == null || graph.length <= 0) return result;

		int[] path = new int[graph.length];

		path[0] = 0;
		dfs(graph, result, path, 1);

		return result;
	}

	private static void dfs(int[][] graph, List<List<Integer>> result, int[] path, int nodeIndex) {
		if (path[nodeIndex - 1] == graph.length - 1) {
			List<Integer> newPath = new LinkedList<>();
			for (int i = 0; i < nodeIndex; i++) {
				newPath.add(path[i]);
			}
			result.add(newPath);
			return;
		}

		int[] target = graph[path[nodeIndex - 1]];

		for (int i = 0; i < target.length; i++) {
			path[nodeIndex] = target[i];
			dfs(graph, result, path, nodeIndex + 1);
		}
	}
}