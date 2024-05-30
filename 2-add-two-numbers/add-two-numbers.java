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
        ListNode newHead = head1;
        int sum = 0,carry = 0;
        while (head1!=null && head2!=null) {
            sum = head1.val + head2.val + carry;
            carry = sum / 10;
            head1.val = sum % 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            sum = head1.val + carry;
            carry = sum / 10;
            head1.val = sum % 10;
            head1 = head1.next;
        }
        ListNode tail = getTail(newHead);
        while (head2 != null) {
            sum = head2.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            tail.next = newNode;
            tail = newNode;
            head2 = head2.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
            newNode = tail;
        }
        return newHead;
    }
    static ListNode getTail(ListNode head) {
        ListNode temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        return temp;
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