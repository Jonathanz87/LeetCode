# problem 19
# Given a linked list, remove the n-th node from the end of list and return its head.
# Example:
# Given linked list: 1->2->3->4->5, and n = 2.
# After removing the second node from the end, the linked list becomes 1->2->3->5.
# Note:
# Given n will always be valid.
# Follow up:
# Could you do this in one pass?

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        
        beforeHead = ListNode(0)
        beforeHead.next = head
        node = beforeHead

        while n > 0:
            head = head.next
            n -= 1

        while head is not None:
            node = node.next
            head = head.next

        if node.next is not None:
            node.next = node.next.next

        return beforeHead.next





one = ListNode(1)
two = ListNode(2)
three = ListNode(3)
four = ListNode(4)
five = ListNode(5)
one.next = two
two.next = three
three.next = four
four.next = five

obj = Solution()

head = obj.removeNthFromEnd(one, 1)

while head is not None:
	print(head.val)
	head = head.next
