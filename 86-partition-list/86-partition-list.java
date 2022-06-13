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
    public ListNode partition(ListNode head, int x) {
        // Initialize 2 parts, left and right, left stores less than x and right stored greater than or equal to x.
        ListNode left = new ListNode(0); 
        ListNode right = new ListNode(0);
        ListNode referenceLeft = left; // reference to the head of left partition
        ListNode referenceRight = right; // reference to the head of right partition
        
        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = left.next;
            }
            else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = referenceRight.next; // merge both the partitions
        return referenceLeft.next;
    }
}