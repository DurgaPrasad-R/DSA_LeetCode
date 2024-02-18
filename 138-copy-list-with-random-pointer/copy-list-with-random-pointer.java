/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        } else {
            Node newHead = new Node(head.val);
            Node temp2 = newHead;
            Map<Node,Node> nodeMap = new HashMap<>();
            nodeMap.put(head,temp2);
            Node temp = head.next;
            while(temp!=null){
                Node newNode = new Node(temp.val);
                nodeMap.put(temp,newNode);
                temp2.next = newNode;
                temp2 = newNode;
                temp = temp.next;
            }
            temp = head;
            temp2 = newHead;
            while(temp!=null){
                temp2.random = nodeMap.get(temp.random);
                temp = temp.next;
                temp2 = temp2.next;
            }
            return newHead;
        }
    }
}