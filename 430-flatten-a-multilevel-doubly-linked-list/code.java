/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    private Node dfs(Node head) {
        Node pre = null;
        while(head != null) {
            pre = head;
            if(head.child != null) {
                // Change the tail node
                Node tail = dfs(head.child);
                tail.next = head.next; // 12 -> 9
                if(head.next != null) {
                    head.next.prev = tail; // 9 <- 12
                }
                
                // Change the head node
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                
                // Reset the pointers
                head = tail.next;
                pre = tail;
            }
            else {
                head = head.next;
            }
        }
        return pre;
    }
}
