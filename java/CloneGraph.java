/*
	problem 133
	Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	OJ's undirected graph serialization:
	Nodes are labeled uniquely.
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	Visually, the graph looks like the following:
		   1
		  / \
		 /   \
		0 --- 2
		     / \
		     \_/
*/

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CloneGraph {
	// Definition for undirected graph.
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
		LinkedList<UndirectedGraphNode> nodeQueue = new LinkedList<>();

		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		nodeMap.put(head.label, head);
		nodeQueue.add(node);

		while (!nodeQueue.isEmpty()) {
			node = nodeQueue.pollFirst();
			UndirectedGraphNode copied = nodeMap.get(node.label);

			for (UndirectedGraphNode n : node.neighbors) {
				UndirectedGraphNode add;
				if (nodeMap.containsKey(n.label)) {
					add = nodeMap.get(n.label);
				} else {
					add = new UndirectedGraphNode(n.label);
					nodeMap.put(n.label, add);
					nodeQueue.add(n);
				}

				copied.neighbors.add(add);
			}
		}

		return head;
	}
}
