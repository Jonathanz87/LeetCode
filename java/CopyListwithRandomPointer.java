/*
	problem 138
	A linked list is given such that each node contains an additional random pointer 
	which could point to any node in the list or null.

	Return a deep copy of the list.
*/

import java.util.Map;
import java.util.HashMap;

public class CopyListwithRandomPointer{


	// Definition for singly-linked list with a random pointer.
	static private class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}

	static public RandomListNode copyRandomList(RandomListNode head){
		RandomListNode beforeHead = new RandomListNode(0);
		RandomListNode newHead = beforeHead;
		Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
		
		while(head != null){
			RandomListNode newNode = null;
			if(nodeMap.containsKey(head)){
				newNode = nodeMap.get(head);
			}else {
				newNode = new RandomListNode(head.label);
				nodeMap.put(head, newNode);
			}

			if(head.random == null){
				newNode.random = null;
			}else if(nodeMap.containsKey(head.random)){
				newNode.random = nodeMap.get(head.random);
			}else {
				RandomListNode newRandom = new RandomListNode(head.random.label);
				newNode.random = newRandom;
				nodeMap.put(head.random, newRandom);
			}

			newHead.next = newNode;
			newHead = newNode;
			head = head.next;
		}

		return beforeHead.next;
	}

	static public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) return null;
		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		
		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		
		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		
		return map.get(head);
	}
}