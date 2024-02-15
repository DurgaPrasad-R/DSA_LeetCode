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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head,prevNode = null,nextNode = null;
        while(temp!=null){
            ListNode KthNode = getKthNode(temp,k);
            if (KthNode == null){
                if (prevNode!=null) prevNode.next = temp;
                break;
            } else {
                nextNode = KthNode.next;
                KthNode.next = null;
                reverseNode(temp);
                if (temp == head){
                    head = KthNode;
                } else {
                    prevNode.next = KthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }
        return head;
    }
    public ListNode getKthNode(ListNode node, int k) {
        k = k - 1;
        while(node!=null && k>0){
            k--;
            node = node.next;
        }
        return node;
    }
    public ListNode reverseNode(ListNode root){
        if (root == null){
            return null;
        } else if ( root.next == null){
            return root;
        }else {
            ListNode p = null;
            ListNode q = root;
            ListNode r = null;
            while(q!=null){
                r = q.next;
                q.next = p;
                p = q;
                q = r;
            }
            root = p;
            return p;
        }

    }
}