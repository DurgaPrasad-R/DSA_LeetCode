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
    public static int getCount(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null) {
            len+=1;
            temp = temp.next;
        }
        return len;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int len = getCount(head);
        ListNode left = head,right = head;
        for(int i = 0;i<k-1;i++) {
            left = left.next;
        }
        for(int i = 0;i<len-k;i++) {
            right = right.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}