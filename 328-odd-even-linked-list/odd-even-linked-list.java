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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int n = 1;
        ListNode oddIdx = new ListNode(0);
        ListNode evenIdx = new ListNode(0);
        ListNode temp = head,evenLast = evenIdx,oddLast = oddIdx;
        while(temp!=null){
            ListNode newNode = new ListNode(temp.val);
            if (n%2 == 1){
                oddLast.next = newNode;
                oddLast = newNode;
            } else {
                evenLast.next = newNode;
                evenLast = newNode;
            }
            n+=1;
            temp = temp.next;
        }
        oddIdx = oddIdx.next;
        evenIdx = evenIdx.next;
        oddLast.next = evenIdx;
        return oddIdx;
    }
}