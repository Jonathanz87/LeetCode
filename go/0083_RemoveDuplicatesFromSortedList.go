/*
	83. Remove Duplicates from Sorted List
	Given a sorted linked list, delete all duplicates such that each element appear only once.
	Example 1:
		Input: 1->1->2
		Output: 1->2
	Example 2:
		Input: 1->1->2->3->3
		Output: 1->2->3
*/

package main

// Definition for singly-linked list.
type ListNode struct {
    Val int
    Next *ListNode
}
 
func deleteDuplicates(head *ListNode) *ListNode {
	tail := head
	for tail != nil && tail.Next != nil {
		if tail.Val == tail.Next.Val {
			tail.Next = tail.Next.Next
		}else{
			tail = tail.Next
		}
	}
	return head
}