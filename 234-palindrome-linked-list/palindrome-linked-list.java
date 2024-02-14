/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
			return true;
		}
		ListNode slow = head,fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHead = reverse(slow.next);
		ListNode temp1 = head,temp2 = secondHead;
		while(temp2!=null){
			if (temp1.val!=temp2.val){
				reverse(secondHead);
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		reverse(secondHead);
		return true;
	}
	public ListNode reverse(ListNode head){
		if (head == null){ 
			return null;
		} else if (head.next == null){
			return head;
		}
		else {
			ListNode p = null;
			ListNode q = head;
			ListNode r = null;
			while(q!=null){
				r = q.next;
				q.next = p;
				p = q;
				q = r;
			}
			head = p;
			return p;
		}
	}
}