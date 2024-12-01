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
    public static ListNode reverse(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        ListNode r = null;
        while(q!=null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
    public int pairSum(ListNode head) {
        if (head == null) return 0;
        ListNode slow = head,fast = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = null;
        ListNode q = head;
        ListNode r;
        while(q!=slow) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        int maxVal = Integer.MIN_VALUE;
        ListNode reversedHead = p;
        ListNode midHead = fast == null ? slow : slow.next;
        while(reversedHead != null && midHead != null) {
            maxVal = Math.max(maxVal,reversedHead.val+midHead.val);
            reversedHead = reversedHead.next;
            midHead = midHead.next;
        }
        return maxVal;
    }
}