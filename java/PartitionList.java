/*
	problem 86
	Given a linked list and a value x,
	partition it such that all nodes less than x come before nodes greater than or equal to x.
	You should preserve the original relative order of the nodes in each of the two partitions.
	For example,
		Given 1->4->3->2->5->2 and x = 3,
		return 1->2->2->4->3->5.
*/

public class PartitionList{
	public static void main(String[] args){

	}

	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode partition(ListNode head, int x){
		ListNode beforeHead1 = new ListNode(0);
		ListNode beforeHead2 = new ListNode(0);
		ListNode tail1 = beforeHead1, tail2 = beforeHead2;

		while(head != null){
			if(head.val < x){
				tail1.next = head;
				tail1 = head;
			}else{
				tail2.next = head;
				tail2 = head;
			}

			head = head.next;
		}

		tail1.next = beforeHead2.next;
		tail2.next = null;

		return beforeHead1.next;
	}
}