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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        int n = 1;
        ListNode temp = head;
        while(temp.next!=null){
            n+=1;
            temp = temp.next;
        }
        temp.next = head;
        k = k%n;
        int last = n - k;
        while(last-- != 0) temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }
}