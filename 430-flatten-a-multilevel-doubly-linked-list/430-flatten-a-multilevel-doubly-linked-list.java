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
    Node current = head; // reference to the head node
    while(current != null) {
      if(current.child != null) {
          
        Node tailNode = findTail(current.child);
          
        if(current.next != null) {
          current.next.prev = tailNode;
        }
          
        tailNode.next = current.next; // move back to prev level after completion of child level
        current.next = current.child; // move down untill the last child and the tail node
        current.child.prev = current; // doubly link
        current.child = null; 
          
      }
      current = current.next; // other levels
    }
    return head;
  }
  
  private Node findTail(Node childNode) {
    while(childNode.next != null) {
      childNode = childNode.next;
    }
    Node tailNode = childNode;

    return tailNode;
  }
}