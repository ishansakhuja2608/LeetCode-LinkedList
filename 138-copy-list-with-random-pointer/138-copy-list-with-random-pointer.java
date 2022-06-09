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
        Node iter = head;
        Node front = head;
        
        // Make copy of each node and create the link 
        while(iter != null) {
            front = iter.next; // saving the original next node in front
            
            Node copy = new Node(iter.val); // creating the copy node
            iter.next = copy; // assigning the original next to copy next
            copy.next = front; // assigning the copy's next to the original next (front)
            
            iter = front; // for further iterations
        }
        
        // assigning random pointers
        iter = head;
        while(iter != null) {
            if(iter.random != null) {
                iter.next.random = iter.random.next; // copy's random = original's random
            }
            iter = iter.next.next;
        }
        
        // restoring the links of the original and copy list
        iter = head;
        Node res = new Node(0);
        Node copy = res;
        
        while(iter != null) {
            front = iter.next.next;
            
            //extract the copy
            copy.next = iter.next;
            copy = copy.next;
            
            //restore the original 
            iter.next = front;
            
            iter = front;
        }
        return res.next;
    }
}