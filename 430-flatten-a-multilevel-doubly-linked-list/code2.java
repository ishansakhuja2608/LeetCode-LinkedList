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
        Node curr = head;
        while(curr != null) {
            if(curr.child == null) {
                curr = curr.next; // if child of current is null, move with the curr node only
                continue;
            }
            Node temp = curr.child;
            while(temp.next != null) {
                temp = temp.next; // traverse till the tail of that child
            }
            temp.next = curr.next; // if tail.next == null, then join the tail.next = curr.next
            if(curr.next != null) {
                curr.next.prev = temp; // join the prev of the next node to the tail
            }
            
            curr.next = curr.child; // move deep down with the child
            curr.child.prev = curr; // rearrange the links
            curr.child = null;
        }
        return head;
    }
}
