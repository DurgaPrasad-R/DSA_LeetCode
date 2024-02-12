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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head,curr = null;
        for(int i = 1;i<=n;i++){    
            temp = temp.next;
        }
        while(temp!=null){
            if (curr == null){
                curr = head;
            } else {
                curr = curr.next;
            }
            temp = temp.next;
        }
        if (curr == null){
            head = head.next;
        } else {
            curr.next = curr.next.next;
        }
        return head;
    }
}