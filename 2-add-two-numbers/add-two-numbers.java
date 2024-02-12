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
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode newHead = null;
        int sum = 0,carry = 0;
        while(head1!=null || head2!=null || carry!=0){
            sum = carry;
            if (head1!=null){
                sum+=head1.val;
                head1 = head1.next;
            }
            if (head2!=null){
                sum+=head2.val;
                head2 = head2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            if (newHead == null){
                newHead = newNode;
            } else {
                newNode.next = newHead;
                newHead = newNode;
            }
        }
        return reverseList(newHead);
    }
    static ListNode reverseList(ListNode head) {
        ListNode r = null, q = head.next, p = head;
        if (q != null && q.next != null) {
            r = q.next;
        }
        while (q != null) {
            q.next = p;
            p = q;
            q = r;
            if (r != null) {
                r = r.next;
            }
        }
        head.next = null;
        head = p;
        return head;
    }
}