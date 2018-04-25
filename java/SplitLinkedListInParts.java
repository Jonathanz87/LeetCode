/*
	problem 725
	Given a (singly) linked list with head node root,
	write a function to split the linked list into k consecutive linked list "parts".
	The length of each part should be as equal as possible:
	no two parts should have a size differing by more than 1.
	This may lead to some parts being null.
	The parts should be in order of occurrence in the input list,
	and parts occurring earlier should always have a size greater than or equal parts occurring later.
	Return a List of ListNode's representing the linked list parts that are formed.
	Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
	Example 1:
	Input:
		root = [1, 2, 3], k = 5
		Output: [[1],[2],[3],[],[]]
		Explanation:
		The input and each element of the output are ListNodes, not arrays.
		For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
		The first element output[0] has output[0].val = 1, output[0].next = null.
		The last element output[4] is null, but it's string representation as a ListNode is [].
	Example 2:
		Input:
		root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
		Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
		Explanation:
		The input has been split into consecutive parts with size difference at most 1,
		and earlier parts are a larger size than the later parts.
	Note:
		The length of root will be in the range [0, 1000].
		Each value of a node in the input will be an integer in the range [0, 999].
		k will be an integer in the range [1, 50].
*/

public class SplitLinkedListInParts {
	// Definition for singly - linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode[] splitListToParts2(ListNode root, int k) {
		ListNode[] result = new ListNode[k];
		int ct = 0;

		ListNode node = root;
		ListNode beforeHead = new ListNode(0);
		beforeHead.next = root;

		while (node != null) {
			ct++;
			node = node.next;
		}

		int reminder = ct % k;
		ct = ct / k;
		int r = 0;

		node = beforeHead;
		for (int i = 0; i < result.length; i++) {
			result[i] = node.next;

			for (int j = 0; j < ct; j++) {
				node = node.next;
			}

			if (r++ < reminder) {
				node = node.next;
			}

			beforeHead.next = node.next;
			node.next = null;
			node = beforeHead;
		}

		return result;
	}

	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode beforeHead = new ListNode(0);
		ListNode[] result = new ListNode[k];
		beforeHead.next = root;
		result[0] = root;
		for (int i = 1; i < result.length; i++) {
			result[i] = beforeHead;
		}

		while (result[0] != null) {
			for (int i = 1; i < result.length && result[0] != null; i++) {
				for (int j = i; j < result.length; j++) {
					result[j] = result[j].next;
				}
				result[0] = result[0].next;
			}
			result[0] = result[0].next;
		}

		result[0] = beforeHead;

		for (int i = 0; i < result.length; i++) {
			if (result[i] != null) {
				ListNode t = result[i];
				result[i] = result[i].next;
				t.next = null;
			}
		}

		return result;
	}

	public static ListNode[] splitListToPartsNoOrder(ListNode root, int k) {
		ListNode beforeHead = new ListNode(0);
		ListNode[] result = new ListNode[k];
		beforeHead.next = root;
		for (int i = 0; i < result.length; i++) {
			result[i] = beforeHead;
		}

		while (result[0] != null) {
			int len = k;
			while (len > 0 && result[0] != null) {
				result[0] = result[0].next;
				len--;
			}

			int ct = k - len - 1;

			for (int i = 1; i < result.length; i++) {
				for (int j = 0; j < ct; j++) {
					result[i] = result[i].next;
				}
				ct--;
			}
		}

		result[0] = root;
		beforeHead.next = null;

		for (int i = 1; i < result.length; i++) {
			ListNode temp = result[i];
			result[i] = result[i].next;
			temp.next = null;
		}

		return result;
	}
}
