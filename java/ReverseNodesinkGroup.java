/*
	problem 25
	Given a linked list, 
	reverse the nodes of a linked list k at a time and return its modified list.
	k is a positive integer and is less than or equal to the length of the linked list. 
	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	You may not alter the values in the nodes, only nodes itself may be changed.
	Only constant memory is allowed.

	For example,
	Given this linked list: 1->2->3->4->5
	For k = 2, you should return: 2->1->4->3->5
	For k = 3, you should return: 3->2->1->4->5
*/

public class ReverseNodesinkGroup{
	static public void main(String[] args){
		int len = args[0].length();
		ListNode beforeHead = new ListNode(0);
		ListNode tail = beforeHead;

		for(int i = 0; i < len; i++){
			tail.next = new ListNode(Character.getNumericValue(args[0].charAt(i)));
			tail = tail.next;
		}

		long startTime=System.nanoTime();
		ListNode temp = reverseKGroup(beforeHead.next, Integer.parseInt(args[1]));
		System.out.println("time: "+(System.nanoTime()-startTime)+"ns");

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Definition for singly-linked list.
	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	static public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) return head;
		ListNode[] storage = new ListNode[k];
		ListNode beforeHead = new ListNode(0);
		beforeHead.next = head;
		head = beforeHead;
		ListNode tail = head.next;
		int i = 0;

		while(tail != null){
			if(i < k){
				storage[i++] = tail;
				tail = tail.next;
			}
			if(i >= k){
				while(i > 0){
					head.next = storage[--i];
					head = head.next;
				}
				head.next = tail;
			}
		}

		return beforeHead.next;
	}

	static public ListNode reverseKGroup2(ListNode head, int k) {
            if (head==null||head.next==null||k<2) return head;
    
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            
            ListNode tail = dummy, prev = dummy,temp;
            int count;
            while(true){
                count =k;
                while(count>0&&tail!=null){
                    count--;
                    tail=tail.next;
                } 
                if (tail==null) break;//Has reached the end
                
    
                head=prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
                while(prev.next!=tail){
                    temp=prev.next;//Assign
                    prev.next=temp.next;//Delete
                    
                    temp.next=tail.next;
                    tail.next=temp;//Insert
                    
                }
                
                tail=head;
                prev=head;
                
            }
            return dummy.next;
           
    }
}