/*
	problem 23
	Merge k sorted linked lists and return it as one sorted list.
	Analyze and describe its complexity.
*/

import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		ListNode node2 = new ListNode(3);
		node2.next = new ListNode(4);
		ListNode[] lists = {node1, node2};

		ListNode node = mergeKListsMergeSort(lists);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode mergeKListsMergeSort(ListNode[] lists) {
		if(lists.length == 0) return null;
		if(lists.length == 1) return lists[0];
		return mergeKListsMergeSort(lists, 0, lists.length - 1);
	}
	private static ListNode mergeKListsMergeSort(ListNode[] lists, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) return lists[leftIndex];

		int midIndex = (leftIndex + rightIndex) / 2;
		return mergeLists(mergeKListsMergeSort(lists, leftIndex, midIndex),
		                  mergeKListsMergeSort(lists, midIndex + 1, rightIndex));
	}

	private static ListNode mergeLists(ListNode node1, ListNode node2) {
		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				current.next = node1;
				node1 = node1.next;
			} else {
				current.next = node2;
				node2 = node2.next;
			}
			current = current.next;
		}

		if (node1 == null) {
			current.next = node2;
		} else {
			current.next = node1;
		}
		return beforeHead.next;
	}

	public static ListNode mergeKListsPriorityQueue(ListNode[] lists) {
		if (lists.length == 0) return null;
		if (lists.length == 1) return lists[0];

		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;

		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			current.next = node;
			current = current.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}

		return beforeHead.next;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		if (lists.length == 1) return lists[0];

		int lastHeadIndex = lists.length / 2 - 1;
		ListNode beforeHead = new ListNode(0);
		ListNode current = beforeHead;

		for (int i = lastHeadIndex; i >= 0; i--) {
			heapify(lists, i);
		}

		while (lists[0] != null) {
			current.next = lists[0];
			current = current.next;
			lists[0] = lists[0].next;

			for (int i = lastHeadIndex; i >= 0; i--) {
				heapify(lists, i);
			}
		}

		return beforeHead.next;
	}

	private static void heapify(ListNode[] heap, int headIndex) {
		int leftIndex = headIndex * 2 + 1;
		int rightIndex = headIndex * 2 + 2;
		int biggestIndex;
		if (rightIndex >= heap.length) {
			biggestIndex = leftIndex;
		} else if (heap[rightIndex] == null) {
			biggestIndex = leftIndex;
		} else if (heap[leftIndex] == null) {
			biggestIndex = rightIndex;
		} else {
			biggestIndex = heap[rightIndex].val < heap[leftIndex].val ? rightIndex : leftIndex;
		}

		if (heap[headIndex] == null) {
			heap[headIndex] = heap[biggestIndex];
			heap[biggestIndex] = null;
		} else if (heap[biggestIndex] != null && heap[biggestIndex].val < heap[headIndex].val) {
			ListNode temp = heap[biggestIndex];
			heap[biggestIndex] = heap[headIndex];
			heap[headIndex] = temp;
		}
	}
}