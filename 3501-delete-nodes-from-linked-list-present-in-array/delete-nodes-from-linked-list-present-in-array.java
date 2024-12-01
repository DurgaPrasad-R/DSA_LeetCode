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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++) {
            set.add(nums[i]);
        }
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(temp!=null) {
            if (!set.contains(temp.val)) {
                ListNode newNode = new ListNode(temp.val);
                tail.next = newNode;
                tail = newNode;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}