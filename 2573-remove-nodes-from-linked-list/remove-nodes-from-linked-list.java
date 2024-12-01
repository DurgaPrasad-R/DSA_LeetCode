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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode temp = head;
        while(temp!=null) {
            if (stk.isEmpty() || stk.peek() >= temp.val) {
                stk.push(temp.val);
            } else {
                while (!stk.isEmpty() && stk.peek() < temp.val) {
                    stk.pop();
                }
                stk.push(temp.val);
            }
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        while(!stk.isEmpty()) {
            ListNode node = new ListNode(stk.pop());
            node.next = dummy;
            dummy = node;
        }
        ListNode prev = dummy;
        temp = dummy;
        while(temp.next!=null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return dummy;
    }
}