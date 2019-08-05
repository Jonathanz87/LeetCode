/*
	2. Add Two Numbers
	You are given two non-empty linked lists representing two non-negative integers.
	The digits are stored in reverse order and each of their nodes contain a single digit.
	Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	Example:
		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
		Explanation: 342 + 465 = 807.
*/

package main

 // Definition for singly-linked list.
 type ListNode struct {
      Val int
      Next *ListNode
  }
 
 func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	beforeHead := ListNode{}
	node := &beforeHead
	
	for l1 != nil && l2 != nil {
		temp := ListNode{}
		temp.Val = (l1.Val + l2.Val + carry) % 10
		carry = (l1.Val + l2.Val + carry) / 10
		node.Next = &temp
        node = node.Next
		l1 = l1.Next
		l2 = l2.Next
	}

	for l1 != nil {
		temp := ListNode{}
		temp.Val = (l1.Val + carry) % 10
		carry = (l1.Val + carry) / 10
		node.Next = &temp
        node = node.Next
		l1 = l1.Next
	}

	for l2 != nil {
		temp := ListNode{}
		temp.Val = (l2.Val + carry) % 10
		carry = (l2.Val + carry) / 10
		node.Next = &temp
        node = node.Next
		l2 = l2.Next
	}

	if carry == 1 {
		temp := ListNode{Val:1}
		node.Next = &temp
	}

	return beforeHead.Next
}