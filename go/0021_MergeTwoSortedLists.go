/*
	21. Merge Two Sorted Lists
	Merge two sorted linked lists and return it as a new list.
	The new list should be made by splicing together the nodes of the first two lists.
	Example:
		Input: 1->2->4, 1->3->4
		Output: 1->1->2->3->4->4
*/

package main

import "fmt"

// Definition for singly-linked list.
type ListNode struct {
    Val int
    Next *ListNode
}

func main() {

	l1 := &ListNode{Val : 1}
	l1.Next = &ListNode{Val : 3}
	l1.Next.Next = &ListNode{Val : 5}

	l2 := &ListNode{Val : 2}
	l2.Next = &ListNode{Val : 4}
	l2.Next.Next = &ListNode{Val : 6}
	l2.Next.Next.Next = &ListNode{Val : 68}

	l := mergeTwoLists(l1, l2)

	for l != nil {
		fmt.Println(l.Val)
		l = l.Next
	}

}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	 if l1 == nil {
		 return l2
	 }

	 if l2 == nil {
		 return l1
	 }

	 beforeHead := ListNode{}
	 current := &beforeHead

	 for l1 != nil && l2 != nil {
		 if l1.Val < l2.Val {
			 current.Next = l1
			 l1 = l1.Next
		 }else {
			 current.Next = l2
			 l2 = l2.Next
		 }
		 current = current.Next
	 }

	 if l1 != nil {
		 current.Next = l1
	 }

	 if l2 != nil {
		 current.Next = l2
	 }

	 return beforeHead.Next
}
