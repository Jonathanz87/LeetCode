/*
	problem 61
	Given a list, rotate the list to the right by k places, where k is non-negative.
	For example:
		Given 1->2->3->4->5->NULL and k = 2,
		return 4->5->1->2->3->NULL.
*/

public class RotateList{
	public static void main(String[] args){
		ListNode head = null;
		for(int i = args[0].length() - 1; i >= 0; i--){
			ListNode temp = new ListNode(args[0].charAt(i) - '0');
			temp.next = head;
			head = temp;
		}

		head = rotateRight(head, Integer.parseInt(args[1]));

		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null) return head;
		ListNode lastNode = head, beforeNewHead = head;
		for(int i = 0; i < k; i++){
			lastNode = lastNode.next;
			if(lastNode == null){
				i = k / (i + 1) * (i + 1) - 1;
				lastNode = head;
			}
		}

		while(lastNode.next != null){
			lastNode = lastNode.next;
			beforeNewHead = beforeNewHead.next;
		}

		lastNode.next = head;
		head = beforeNewHead.next;
		beforeNewHead.next = null;
		return head;
	}
}