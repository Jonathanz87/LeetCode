/*
	206. Reverse Linked List
	Reverse a singly linked list.
	Example:
		Input: 1->2->3->4->5->NULL
		Output: 5->4->3->2->1->NULL
	Follow up:
		A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

// Definition for singly-linked list.
type ListNode struct {
	Val int
	Next *ListNode
}
 
func reverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
		return head
	}

	h, t := reverse(head)
	t.Next = nil
	return h
}

func reverse(head *ListNode) (*ListNode, *ListNode) {
    if head.Next == nil {
		return head, head
	}

	h, t := reverse(head.Next)

	t.Next = head

	return h, head
}

func reverseList2(head *ListNode) (newHead *ListNode) {
	for head != nil {
		temp := head.Next
		head.Next = newHead
		newHead = head
		head = temp
	}
}