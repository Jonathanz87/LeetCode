/*
	problem 160
	Write a program to find the node at which the intersection of two singly linked lists begins.
	For example, the following two linked lists:
	A: 		a1 → a2
					↘
					 c1 → c2 → c3
					↗
	B: b1 → b2 → b3
	begin to intersect at node c1.
	Notes:
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
*/

/*
	solution: 			(	list A 			  )  (	append list B 			)
	convert list A to 	a1 → a2 → c1 → c2 → c3 → b1 → b2 → b3 → !c1! → c2 → c3 → a1 ...
	convert list B to 	b1 → b2 → b3 → c1 → c2 → c3 → a1 → a2 → !c1! → c2 → c3 → b1 ...
						(	list B 			  )  (	append list A 			)

	use two pointers traverse lists,
	the two pointers will meet at position p where p < len(A + B)
	the two pointers will never meet iff there is no join position in lists,
	in this case the pointer for list A or B will meet its own head at position len(A + B) + 1
*/

public class IntersectionOfTwoLinkedLists {
	//Definition for singly - linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		ListNode current = headA;
		int[] nums = new int[] {3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
		for (int num : nums) {
			current.next = new ListNode(num);
			current = current.next;
		}
		current = getIntersectionNode2(headA, headB);

		System.out.println(current.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		if (headA == headB) {
			return headA;
		}

		ListNode currentA = new ListNode(0);
		currentA.next = headA;
		headA = currentA;

		ListNode currentB = new ListNode(0);
		currentB.next = headB;
		headB = currentB;

		ListNode breakPoint = currentA;

		while (currentA != currentB) {
			currentA = currentA == null ? headB : currentA.next;
			currentB = currentB == null ? headA : currentB.next;
			if (currentA == breakPoint) {
				break;
			}
		}

		return currentA  == breakPoint ? null : currentA;
	}

	/*
		solution 2
		traverse list A and B to get length of them
		move pointer A or B to position (lenA - LenB) of (lenB - lenA) to make two list same length
				p1
		A: 		a1 → a2
						↘
						 c1 → c2 → c3
						↗
		B: b1 → b2 → b3
				p2

		then repeatedly move p1 and p2 1 node forward until p1 == p2 (join point or null)
	*/
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int len = 0;
		for (ListNode current = headA; current != null; current = current.next) {
			len++;
		}

		for (ListNode current = headB; current != null; current = current.next) {
			len--;
		}

		while (len > 0) {
			headA = headA.next;
			len--;
		}

		while (len < 0) {
			headB = headB.next;
			len++;
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}
}