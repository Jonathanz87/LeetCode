/*
	problem 83
	Given a sorted linked list,
	delete all duplicates such that each element appear only once.
	For example,
		Given 1->1->2, return 1->2.
		Given 1->1->2->3->3, return 1->2->3.
*/

public class RemoveDuplicatesfromSortedList{
	public static void main(String[] args){
		ListNode head = new ListNode(args[0].charAt(0) - '0');
		ListNode node = head;
		for(int i = 1, len = args[0].length(); i < len; i++){
			node.next = new ListNode(args[0].charAt(i) - '0');
			node = node.next;
		}

		node = head;
		while(node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		head = deleteDuplicates(head);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	// Definition for singly-linked list.
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode deleteDuplicates(ListNode head){
		ListNode node = head;

		while(node != null && node.next != null){
			if(node.val == node.next.val){
				node.next = node.next.next;
			}else{
				node = node.next;
			}
		}

		return head;
	}
}